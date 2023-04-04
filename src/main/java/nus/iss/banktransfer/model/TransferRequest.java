package nus.iss.banktransfer.model;

public class TransferRequest {

    private String accountFrom;
    private String accountTo;
    private Float amount;
    public TransferRequest() {
    }
    public TransferRequest(String accountFrom, String accountTo, Float amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }
    public String getAccountFrom() {
        return accountFrom;
    }
    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }
    public String getAccountTo() {
        return accountTo;
    }
    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }
    public Float getAmount() {
        return amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "TransferRequest [accountFrom=" + accountFrom + ", accountTo=" + accountTo + ", amount=" + amount + "]";
    }
       

    
}
