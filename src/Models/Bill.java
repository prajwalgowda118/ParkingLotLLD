package Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{

    private Date exitDate;
    private Ticket ticket;
    private Gate exitGate;
    private Operator exitOperator;
    private long amount;
    public List<Payment> paymentList;

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public Operator getExitOperator() {
        return exitOperator;
    }

    public void setExitOperator(Operator exitOperator) {
        this.exitOperator = exitOperator;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
