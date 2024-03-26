package TEAM6.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "routes")
public class Route {
//    ATTRIBUTES
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String deploy;
        @Column(name = "last_stop")
        private String lastStop;
        @Column(name = "average_time")
        private double averageTime;
        @OneToMany(mappedBy = "route")
        private List<Transport> transportList;

//        CONSTRUCTORS
    public Route() {

    }
        public Route(String deploy, String lastStop, double averageTime) {
            this.deploy = deploy;
            this.lastStop =lastStop;
            this.averageTime = averageTime;

        }

//    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public String getDeploy() {
        return deploy;
    }

    public void setDeploy(String deploy) {
        this.deploy = deploy;
    }

    public String getLastStop() {
        return lastStop;
    }

    public void setLastStop(String lastStop) {
        this.lastStop = lastStop;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }

    public List<Transport> getTransportList() {
        return transportList;
    }

    public void setTransportList(List<Transport> transportList) {
        this.transportList = transportList;
    }

    //        TO STRING
    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", deploy='" + deploy + '\'' +
                ", lastStop='" + lastStop + '\'' +
                ", averageTime=" + averageTime +
                '}';
    }
}
