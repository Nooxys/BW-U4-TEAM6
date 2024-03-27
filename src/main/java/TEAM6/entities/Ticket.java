package TEAM6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@NamedQuery(name = "numberOfTicketsByStoreAndDate", query = "SELECT COUNT(t) FROM Ticket t WHERE t.store.id = :storeId GROUP BY EXTRACT(MONTH FROM t.emissionDate) HAVING EXTRACT(MONTH FROM t.emissionDate) = :month ")
@NamedQuery(name = "updateTicketStatus", query = "UPDATE Ticket t SET t.isUsed = true WHERE t.id = :id AND t.isUsed = false")
@NamedQuery(name = "countTicketByMonth", query = "SELECT COUNT(t) FROM Ticket t GROUP BY EXTRACT(MONTH FROM t.emissionDate) HAVING EXTRACT(MONTH FROM t.emissionDate) = :month")
public class Ticket extends Rate {

    // ATTRIBUTES
    LocalDate emissionDate;

    @Column(name = "is_used")
    private boolean isUsed;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    // CONSTRUCTOR
    public Ticket(){
    }

    public Ticket(Store store, User user, boolean isUsed, Transport transport, LocalDate emissionDate) {
        super(store, user);
        setPrice();
        this.isUsed = isUsed;
        this.transport = transport;
        this.emissionDate = emissionDate;
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

    @Override
    public void setPrice(){
        this.price = 2.50;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Ticket{" +
                "emissionDate=" + emissionDate +
                ", isUsed=" + isUsed +
                ", transport=" + transport +
                ", id=" + id +
                ", price=" + price +
                ", store=" + store +
                '}';
    }
}