package TEAM6.entities;

import jakarta.persistence.*;

//@Entity
//@Table(name = "stores")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Stores {
//    @Id
//    @GeneratedValue
    protected long id;
    protected String location;

    public Stores(String location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Stores{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
