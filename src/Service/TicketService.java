package Service;

import Models.*;
import Repository.GateRepository;

import Exception.InvalidGateException;
import Repository.VehicleRepository;

import java.util.Optional;

public class TicketService {


    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository
    , VehicleRepository vehicleRepository   )
    {
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
    }

    public Ticket GenarateTicket(long gateID, String vehicalNumber, VehicleType vehicleType) throws InvalidGateException {


        //1get the gate details if exist from the in memory of the gate repo

        Optional<Gate> gateOptional=gateRepository.FindGateByID(gateID);

        if (!gateOptional.isPresent()) {
            throw new InvalidGateException();
        }

        Gate gate=gateOptional.get();
        Operator currentOperator=gate.getOperator();


        Optional<Vehicle> vehOptional=gateRepository.FindGateByID(gateID);

        if (!gateOptional.isPresent()) {
            throw new InvalidGateException();
        }


        return null;

    }
}
