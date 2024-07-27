package Controller;

import DTOS.GenerateTicketRequestDto;
import DTOS.GenerateTicketResponseDto;
import Models.Ticket;
import Models.VehicleType;
import Service.TicketService;

import Exception.InvalidGateException;


public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {

        this.ticketService = ticketService;
    }

   /* public GenerateTicketResponseDto generateTicket(long gateID, String vehicalNumber, VehicleType vehicleType){

        //lot of parameter so pass the dto and get the necessary info from that //


    }*/
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request)
    {

        //lot of parameter so pass the dto and get the necessary info from that //
        String vehicalNumber= request.getVehicalNumber();
        long gateId=request.getGateId();
        VehicleType vehicleType=request.getVehicleType();


        Ticket ticket=new Ticket();
        GenerateTicketResponseDto response=new GenerateTicketResponseDto();

        try{
            ticket= ticketService.GenarateTicket(gateId,vehicalNumber,vehicleType);
        }catch (InvalidGateException e) {
          response.se
        }




        return null;

    }

}
