package TEAM6.exceptions;

public class NoStoreException extends  RuntimeException{
    public NoStoreException(long id) {
        super("The store " + id + " is not saved in the Database. Please check the ID");
    }
}
