package TEAM6.entities;

import TEAM6.enums.TransportStatus;
import TEAM6.enums.TransportType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "transports")
public class Transport {

    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type")
    private TransportType transportType;
    private int capacity;
    private String model;
    @Enumerated(EnumType.STRING)
    @Column(name = "transport_status")
    private TransportStatus transportStatus;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @OneToMany(mappedBy = "transport")
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "transport")
    private List<Maintenance> maintenanceList;

    //    CONSTRUCTORS
    public Transport(TransportType transportType, String model, TransportStatus transportStatus, Route route) {
        this.transportType = transportType;
        setCapacity();
        this.model = model;
        this.transportStatus = transportStatus;
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

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    public void setMaintenanceList(List<Maintenance> maintenanceList) {
        this.maintenanceList = maintenanceList;
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
                ", route=" + route +
                '}';
    }

//    public void printValidatedTicketsCount(){
//        List<Ticket> validateTickets = this.getTicketList().stream().filter(Ticket::isUsed).toList();
//        System.out.println(validateTickets.size());
//    }
//
//    public void checkTicket(Ticket ticket){
//        if (ticket.isUsed()) {
//            System.out.println("The ticket has been already used");
//        } else {
//            System.out.println("The ticket has been correctly validated");
//        }
//    }
}
