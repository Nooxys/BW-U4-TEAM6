package TEAM6.exceptions;


public class NoFoundException extends RuntimeException {
    public NoFoundException(long id) {
        super("The element with " + id + " ID was not found.");
    }
}
