package TEAM6.entities;

import TEAM6.enums.SubType;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Entity
@Table(name = "subscriptions")
public class Subscription extends Rate {

    // ATTRIBUTES
    private SubType type;
    @Column(name = "starting_date")
    private LocalDate startingDate;
    @Column(name = "ending_date")
    private LocalDate endingDate;
    private long duration;




    // CONSTRUCTORS

    public Subscription(){

    }
    public Subscription(double price,Store store, SubType type ) {
        super(price,store);
        this.type = type;
        setStartingDate();
        setEndingDate();
        setDuration();
    }

    // METHODS


    public SubType getType() {
        return type;
    }

    public void setType(SubType type) {
        this.type = type;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate() {
        Random random = new Random();
        if ( this.type == SubType.WEEKLY) {

            this.startingDate = LocalDate.of(2024, random.nextInt(1,7), random.nextInt(1,29));
        } else {
            this.startingDate = LocalDate.of(2024, random.nextInt(1,7),1);
        }
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate() {
        if ( this.type == SubType.WEEKLY) {

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
