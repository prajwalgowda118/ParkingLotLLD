package Controller;

import DTOS.GenerateTicketRequestDto;
import DTOS.GenerateTicketResponseDto;
import DTOS.ResposneStatus;
import Models.Ticket;
import Models.VehicleType;
import Service.TicketService;

//import Exception.InvalidGateException;
//import Exception.InvalidParkingLotException;
import Exception.*;



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
          response.setMessage("Invalid Gate");
          response.setResposneStatus(ResposneStatus.FAILURE);
          return response;
        }catch (InvalidParkingLotException e) {

            response.setMessage("Invalid Parking Lot");
            response.setResposneStatus(ResposneStatus.FAILURE);
            return response;
        }catch (NoSpotFoundException e){
            response.setMessage("No Spot Found");
            response.setResposneStatus(ResposneStatus.SUCCESS);
            return response;
        }

        response.setTicketId(ticket.getId());
        response.setOperatorName(ticket.getCurrentOperator().getOperatorName());
        response.setSpotNumber(ticket.getParkingSpot().getSpotNumber());
        response.setVehicleNumber(ticket.getVehicle().getVehicleName());
        response.setMessage("Ticket Generated");
        response.setResposneStatus(ResposneStatus.SUCCESS);

        return response;



        //return null;

    }
    public long feeCalculation(long ticketId) throws InvaildTicketException
    {

            long feeCalculation=0;
            try {

                feeCalculation = ticketService.feeCalucation(ticketId);

            }catch (InvaildTicketException e) {
                throw new InvaildTicketException();

            }
            return feeCalculation;


    }

}
