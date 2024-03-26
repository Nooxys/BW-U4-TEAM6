package TEAM6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rates")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Rate {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  long id;
    protected double price;

    // CONSTRUCTORS
    public Rate(){

    }
    public Rate(double price) {
        this.price = price;
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
                '}';
    }
}
