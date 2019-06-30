package firstproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author Elza
 */
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private long nrCc;
    private String expDd;
    private int ccv;
    private double balance;
    @ManyToOne
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "creditCard")
    @JsonIgnore
    private List<Payment> payment;

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
