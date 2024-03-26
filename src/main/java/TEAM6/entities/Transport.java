package TEAM6.entities;

import TEAM6.enums.TransportStatus;
import TEAM6.enums.TransportType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Entity
@Table(name = "transports")
public class Transport {

    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "transport_type")
    private TransportType transportType;
    private int capacity;
    private String model;
    @Column(name = "transport_status")
    private TransportStatus transportStatus;
    @Column(name = "on_service_start")
    private LocalDate onServiceStart;
    @Column(name = "on_service_end")
    private LocalDate onServiceEnd;
    @Column(name = "on_service_days")
    private long onServiceDays;
    @Column(name = "under_maintenance_start")
    private LocalDate underMaintenanceStart;
    @Column(name = "under_maintenance_end")
    private LocalDate underMaintenanceEnd;
    @Column(name = "under_maintenance_days")
    private long underMaintenanceDays;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    //    CONSTRUCTORS
    public Transport(TransportType transportType, String model, TransportStatus transportStatus, Route route) {
        this.transportType = transportType;
        setCapacity();
        this.model = model;
        this.transportStatus = transportStatus;
        setOnServiceStart();
        setOnServiceEnd();
        setOnServiceTime();
        setUnderMaintenanceStart();
        setUnderMaintenanceEnd();
        setUnderMaintenanceTime();
        this.route = route;
    }

    public Transport() {

    }

    //    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity() {
        if (this.transportType == TransportType.BUS) {
            this.capacity = 53;
        } else this.capacity = 150;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TransportStatus getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(TransportStatus transportStatus) {
        this.transportStatus = transportStatus;
    }

    public LocalDate getOnServiceStart() {
        return onServiceStart;
    }

    public void setOnServiceStart() {
        if (this.transportStatus == TransportStatus.ON_SERVICE) {
            Random random = new Random();
            this.onServiceStart = LocalDate.of(2024, random.nextInt(1, 7), random.nextInt(1, 29));
        } else this.onServiceStart = null;
    }

    public LocalDate getOnServiceEnd() {
        return onServiceEnd;
    }

    public void setOnServiceEnd() {
        if (this.transportStatus == TransportStatus.ON_SERVICE) {
            Random random = new Random();
            this.onServiceEnd = this.onServiceStart.plusDays(random.nextInt(120, 180));
        } else this.onServiceEnd = null;
    }

    public long getOnServiceTime() {
        return onServiceDays;
    }

    public void setOnServiceTime() {
        if(this.transportStatus == TransportStatus.ON_SERVICE) {
            this.onServiceDays = ChronoUnit.DAYS.between(this.onServiceStart, this.onServiceEnd);
        } else this.onServiceDays = 0;
    }

    public LocalDate getUnderMaintenanceStart() {
        return underMaintenanceStart;
    }

    public void setUnderMaintenanceStart() {
        if (this.transportStatus == TransportStatus.UNDER_MAINTENANCE) {
            Random random = new Random();
            this.underMaintenanceStart = LocalDate.of(2024, random.nextInt(1, 7), random.nextInt(1, 29));
        } else this.underMaintenanceStart = null;
    }

    public LocalDate getUnderMaintenanceEnd() {
        return underMaintenanceEnd;
    }

    public void setUnderMaintenanceEnd() {
        if (this.transportStatus == TransportStatus.UNDER_MAINTENANCE) {
            Random random = new Random();
            this.underMaintenanceEnd = this.underMaintenanceStart.plusDays(random.nextInt(15, 31));
        } else this.underMaintenanceEnd = null;
    }

    public long getUnderMaintenanceTime() {
        return underMaintenanceDays;
    }

    public void setUnderMaintenanceTime() {
        if(this.transportStatus == TransportStatus.UNDER_MAINTENANCE) {
            this.underMaintenanceDays = ChronoUnit.DAYS.between(this.underMaintenanceStart, this.underMaintenanceEnd);
        } else this.underMaintenanceDays = 0;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", transportType=" + transportType +
                ", capacity=" + capacity +
                ", model='" + model + '\'' +
                ", transportStatus=" + transportStatus +
                ", onServiceStart=" + onServiceStart +
                ", onServiceEnd=" + onServiceEnd +
                ", onServiceDays=" + onServiceDays +
                ", underMaintenanceStart=" + underMaintenanceStart +
                ", underMaintenanceEnd=" + underMaintenanceEnd +
                ", underMaintenanceDays=" + underMaintenanceDays +
                ", route=" + route +
                '}';
    }
}
