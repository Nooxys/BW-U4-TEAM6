package TEAM6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends Rate {

    // ATTRIBUTES
    @Column(name = "is_used")
    private boolean isUsed;

    // CONSTRUCTOR

    public Ticket(){
    }
    public Ticket( double price,Store store, boolean isUsed) {
        super( price,store);
        this.isUsed = isUsed;
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



    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", isUsed=" + isUsed +
                ", id=" + id +
                ", isUsed=" + isUsed +
                ", price=" + price +
                '}';
    }
}