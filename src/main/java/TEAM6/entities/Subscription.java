package TEAM6.entities;

import TEAM6.enums.TransportType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Subscription extends Rate {

    // ATTRIBUTES

    private long id;
    private TransportType.SubType type;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private long duration;


    // CONSTRUCTORS

    public Subscription(){

    }
    public Subscription(double price, TransportType.SubType type ) {
        super(price);
        this.type = type;
        setStartingDate();
        setEndingDate();
        setDuration();
    }

    // METHODS


    public TransportType.SubType getType() {
        return type;
    }

    public void setType(TransportType.SubType type) {
        this.type = type;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate() {
        Random random = new Random();
        if ( this.type == TransportType.SubType.WEEKLY) {

            this.startingDate = LocalDate.of(2024, random.nextInt(1,7), random.nextInt(1,29));
        } else {
            this.startingDate = LocalDate.of(2024, random.nextInt(1,7),1);
        }
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate() {
        if ( this.type == TransportType.SubType.WEEKLY) {

            this.endingDate = this.startingDate.plusDays(7) ;
        } else { this.endingDate = this.startingDate.plusMonths(1).minusDays(1);
        }
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration() {
        this.duration = ChronoUnit.DAYS.between(this.startingDate, this.endingDate);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", type=" + type +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", duration=" + duration +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
