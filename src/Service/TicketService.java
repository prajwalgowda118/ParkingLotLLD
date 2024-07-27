package Service;

import Models.Gate;
import Models.Operator;
import Models.Ticket;
import Models.VehicleType;
import Repository.GateRepository;

import Exception.InvalidGateException;
import java.util.Optional;

public class TicketService {


    private GateRepository gateRepository;

    public TicketService(GateRepository gateRepository)
    {
        this.gateRepository=gateRepository;
    }

    public Ticket GenarateTicket(long gateID, String vehicalNumber, VehicleType vehicleType) throws InvalidGateException {


        //1get the gate details if exist from the in memory of the gate repo

        Optional<Gate> gateOptional=gateRepository.FindGateByID(gateID);

        if (!gateOptional.isPresent()) {
            throw new InvalidGateException();
        }
        Gate gate=gateOptional.get();

        Operator currentOperator=gate.getOperator();



        return null;

    }
}
