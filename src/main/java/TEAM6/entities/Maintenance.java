package TEAM6.entities;

import TEAM6.enums.MaintenanceType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Entity
@Table(name = "maintenances")
public class Maintenance {

//    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "maintenance_start")
    private LocalDate maintenanceStart;
    @Column(name = "maintenance_end")
    private LocalDate maintenanceEnd;
    private long duration;
    @Enumerated(EnumType.STRING)
    private MaintenanceType maintenanceType;
    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

//    CONSTRUCTORS
    public Maintenance(MaintenanceType maintenanceType, Transport transport) {
        this.maintenanceType = maintenanceType;
        this.transport = transport;
        setMaintenanceStart();
        setMaintenanceEnd();
        setDuration();
    }

    public Maintenance(){}

//    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public LocalDate getMaintenanceStart() {
        return maintenanceStart;
    }

    public void setMaintenanceStart() {
        Random random = new Random();
        this.maintenanceStart = LocalDate.of(random.nextInt(2020, 2025), random.nextInt(1, 6), random.nextInt(1, 29));
    }

    public LocalDate getMaintenanceEnd() {
        return maintenanceEnd;
    }

    public void setMaintenanceEnd() {
        switch (this.maintenanceType){
            case ENGINE_PROBLEM -> this.maintenanceEnd = this.maintenanceStart.plusDays(20);
            case TIRES_CHANGE, ROUTINE_CHECK_UP -> this.maintenanceEnd = this.maintenanceStart.plusDays(1);
            case SANITATION -> this.maintenanceEnd = this.maintenanceStart.plusDays(7);
            case GENERIC_PROBLEM -> this.maintenanceEnd = this.maintenanceStart.plusDays(10);
        }
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration() {
        this.duration = ChronoUnit.DAYS.between(this.maintenanceStart, this.maintenanceEnd);
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
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
        return "Maintenance{" +
                "id=" + id +
                ", maintenanceStart=" + maintenanceStart +
                ", maintenanceEnd=" + maintenanceEnd +
                ", duration=" + duration +
                ", maintenanceType=" + maintenanceType +
                ", transport=" + transport +
                '}';
    }
}
