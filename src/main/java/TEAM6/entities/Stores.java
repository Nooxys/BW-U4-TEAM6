package TEAM6.entities;

import TEAM6.enums.TransportType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

//@Entity
//@Table(name = "stores")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Stores {
    //    ATTRIBUTES
//    @Id
//    @GeneratedValue
    protected long id;
    protected String location;

    //    CONSTRUCTORS
    public Stores(String location) {
        this.location = location;
    }

    public Stores() {}

    //    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Stores{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
