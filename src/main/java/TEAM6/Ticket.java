package TEAM6;

public class Ticket extends Rate{

    // ATTRIBUTES
    private long id;
    private boolean isUsed;

   // CONSTRUCTOR

    public Ticket(){
    }
    public Ticket( double price, boolean isUsed) {
        super( price);
        this.isUsed = isUsed;
    }

    // METHODS

    @Override
    public long getId() {
        return id;
    }


    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", isUsed=" + isUsed +
                ", id=" + id +
                ", isUsed=" + isUsed +
                ", price=" + price +
                '}';
    }
}
