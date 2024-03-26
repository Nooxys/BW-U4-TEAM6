package TEAM6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dispenser")
public class Dispenser extends Store{

//    ATTRIBUTES
    private boolean status;

//    CONSTRUCTORS
    public Dispenser(String location, boolean status) {
        super(location);
        this.status = status;
    }

    public Dispenser(){}

//    GETTERS AND SETTERS
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


//    TO STRING
    @Override
    public String toString() {
        return "Dispenser{" +
                "status=" + status +
                '}';
    }

}
