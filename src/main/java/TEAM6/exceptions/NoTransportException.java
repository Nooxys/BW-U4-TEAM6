package TEAM6.exceptions;

public class NoTransportException extends RuntimeException {
    public NoTransportException(long id) {
        super("The transport " + id + " is not available.");
    }
}
