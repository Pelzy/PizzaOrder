package firstproject.demo.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import firstproject.demo.entity.Payment;
import firstproject.demo.entity.User;

import java.util.List;

public class CreditCardTransport {
    private String id;
    private long nrCc;
    @JsonIgnore
    private String expDd;
    @JsonIgnore
    private int ccv;
    @JsonIgnore
    private double balance;
    @JsonIgnore
    private List<Payment> payment;
    @JsonIgnore
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNrCc() {
        return nrCc;
    }

    public void setNrCc(long nrCc) {
        this.nrCc = nrCc;
    }

    public String getExpDd() {
        return expDd;
    }

    public void setExpDd(String expDd) {
        this.expDd = expDd;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
