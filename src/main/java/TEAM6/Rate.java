package TEAM6;

public abstract class Rate {

    // ATTRIBUTES
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
