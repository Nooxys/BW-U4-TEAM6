package TEAM6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "dispenser")
public class Dispenser extends Stores{
    private boolean status;
    public Dispenser(String location, boolean status) {
        super(location);
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dispenser{" +
                "status=" + status +
                '}';
    }

}
