package Service;

import Models.*;
import Repository.GateRepository;

import Exception.InvalidGateException;
import Repository.ParkingLotRepository;
import Repository.TicketRepository;
import Repository.VehicleRepository;
import Exception.InvalidParkingLotException;
import Strategies.FeeStrategies.FeeCalculationStrategies;
import Strategies.SpotAssignmentStrategies.SpotAssignment;
import Exception.*;

import java.util.Date;
import java.util.Optional;

public class TicketService {


    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private SpotAssignment spotAssignment;
    private TicketRepository ticketRepository;
    private FeeCalculationStrategies feeCalculationStrategies;


    public TicketService(  GateRepository gateRepository
                         , VehicleRepository vehicleRepository
                         , ParkingLotRepository parkingLotRepository
                        , SpotAssignment spotAssignment, TicketRepository ticketRepository
                        ,FeeCalculationStrategies feeCalculationStrategies)
    {
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;
        this.spotAssignment=spotAssignment;
        this.ticketRepository=ticketRepository;
        this.feeCalculationStrategies=feeCalculationStrategies;
    }

    public Ticket GenarateTicket(long gateID, String vehicalNumber, VehicleType vehicleType) throws InvalidGateException, InvalidParkingLotException,NoSpotFoundException
    {


        //1get the gate details if exist from the in memory of the gate repo

        Optional<Gate> gateOptional=gateRepository.FindGateByID(gateID);

        if (!gateOptional.isPresent()) {
            throw new InvalidGateException();
        }

        Gate gate=gateOptional.get();

        Operator currentOperator=gate.getOperator();

        Optional<Vehicle> vehOptional=vehicleRepository.findVehicleByVehicalNumber(vehicalNumber);

        Vehicle vehicle = new Vehicle();

        if (!vehOptional.isPresent()) {

            vehicle.setVehicleName(vehicalNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle=vehicleRepository.save(vehicle);

        }else {
            vehicle=vehOptional.get();
        }

        Optional<ParkingLot> optionalParkingLotOptional=parkingLotRepository.getParkingLotofGate(gate);

        if (!optionalParkingLotOptional.isPresent()) {
            throw new InvalidParkingLotException();
        }

        ParkingLot parkingLot=optionalParkingLotOptional.get();

        Optional<ParkingSpot> spot = spotAssignment.getSpotStrategis(gate,vehicleType,parkingLot);

        if (!spot.isPresent()) {
            throw new NoSpotFoundException();
        }

        Ticket ticket=new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryDate(new Date());
        ticket.setCurrentOperator(currentOperator);
        ticket.setParkingSpot(spot.get());

        return ticketRepository.save(ticket);

    }

    public long feeCalucation(long ticketId) throws InvaildTicketException {

        Optional<Ticket> ticketOptional = ticketRepository.findTicketById(ticketId);
        if (!ticketOptional.isPresent()) {
            throw new InvaildTicketException();

        }

        Ticket ticket = ticketOptional.get();
        long durationInHours = (new Date().getTime() - ticket.getEntryDate().getTime()) / (1000 * 60 * 60);

        Long ans=feeCalculationStrategies.CalculateFee(durationInHours,ticket.getVehicle().getVehicleType());

        return ans;



    }
}
