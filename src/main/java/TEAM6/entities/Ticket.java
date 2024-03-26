package TEAM6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends Rate {

    // ATTRIBUTES
    @Column(name = "is_used")
    private boolean isUsed;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    // CONSTRUCTOR
    public Ticket(){
    }

    public Ticket(double price, Store store, User user, boolean isUsed, Transport transport) {
        super(price, store, user);
        this.isUsed = isUsed;
        this.transport = transport;
    }

    // METHODS
    @Override
    public long getId() {
        return id;
    }


    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

//    TO STRING
    @Override
    public String toString() {
        return "Ticket{" +
                "isUsed=" + isUsed +
                ", transport=" + transport +
                ", id=" + id +
                ", price=" + price +
                ", store=" + store +
                ", user=" + user +
                '}';
    }
}