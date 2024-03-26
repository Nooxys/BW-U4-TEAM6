package TEAM6.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rates")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Rate {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Rate(double price, Store store,User user) {
        this.price = price;
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
