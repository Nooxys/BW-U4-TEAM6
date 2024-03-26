package TEAM6.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rates")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Rate {

    // ATTRIBUTES
    @Id
    @GeneratedValue
    protected  long id;
    protected double price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    protected Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    // CONSTRUCTORS
    public Rate(){

    }
    public Rate(Store store,User user) {
        setPrice();
        this.store = store;
        this.user = user;
    }

    // METHODS

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void setPrice();

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", price=" + price +
                ", store=" + store +
                ", user=" + user +
                '}';
    }
}
