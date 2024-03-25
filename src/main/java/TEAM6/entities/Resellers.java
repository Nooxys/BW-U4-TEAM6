package TEAM6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;

//@Entity
//@Table(name = "resellers")
public class Resellers extends Stores{
    private LocalTime openingTime;
    private LocalTime closingTime;

    public Resellers(String location, LocalTime openingTime, LocalTime closingTime) {
        super(location);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

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

    @Override
    public String toString() {
        return "Resellers{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
