package DTOS;

public class GenerateTicketResponseDto {

    private long ticketId;;
    private String message;
    private String spotNumber;
    private ResposneStatus resposneStatus;
    private String vehicleNumber;;
    private String operatorName;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ResposneStatus getResposneStatus() {
        return resposneStatus;
    }

    public void setResposneStatus(ResposneStatus resposneStatus) {
        this.resposneStatus = resposneStatus;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
