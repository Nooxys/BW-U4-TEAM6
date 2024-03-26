package TEAM6.entities;

//@Table(name = "routes")
public class Route {

//    ATTRIBUTES
        //@Id
        //@GeneratedValue
        private long id;
        private String deploy;
        private String lastStop;
        private double averageTime;


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
