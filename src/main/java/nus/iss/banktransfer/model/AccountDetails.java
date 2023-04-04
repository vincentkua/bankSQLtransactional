package nus.iss.banktransfer.model;

import java.sql.Date;
import java.time.LocalDateTime;


public class AccountDetails {

    private Integer id ;
    private String accountName;
    private Float balance;
    private LocalDateTime datetimeCreated;
    private Date dateExpiry;
    public AccountDetails() {
    }
    public AccountDetails(Integer id, String accountName, Float balance, LocalDateTime datetimeCreated,
            Date dateExpiry) {
        this.id = id;
        this.accountName = accountName;
        this.balance = balance;
        this.datetimeCreated = datetimeCreated;
        this.dateExpiry = dateExpiry;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public Float getBalance() {
        return balance;
    }
    public void setBalance(Float balance) {
        this.balance = balance;
    }
    public LocalDateTime getDatetimeCreated() {
        return datetimeCreated;
    }
    public void setDatetimeCreated(LocalDateTime datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }
    public Date getDateExpiry() {
        return dateExpiry;
    }
    public void setDateExpiry(Date dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
    @Override
    public String toString() {
        return "AccountDetails [id=" + id + ", accountName=" + accountName + ", balance=" + balance
                + ", datetimeCreated=" + datetimeCreated + ", dateExpiry=" + dateExpiry + "]";
    }

    
    
}
