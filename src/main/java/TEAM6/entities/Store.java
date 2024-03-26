package TEAM6.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "stores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "store_type")
public abstract class Store {

    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String location;

    @OneToMany(mappedBy = "store")
    protected List<Rate> rateList;


    //    CONSTRUCTORS
    public Store(String location) {
        this.location = location;
    }

    public Store() {}

    //    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Stores{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
