package TEAM6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

//@Entity
//@Table(name = "resellers")
public class Reseller extends Store{

//    ATTRIBUTES
    private LocalTime openingTime;
    private LocalTime closingTime;

//    CONSTRUCTORS
    public Reseller(String location, LocalTime openingTime, LocalTime closingTime) {
        super(location);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Reseller(){}

//    GETTERS AND SETTERS
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

//    TO STRING
    @Override
    public String toString() {
        return "Reseller{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
