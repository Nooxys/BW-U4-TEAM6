package TEAM6.exceptions;

public class NoUserException extends  RuntimeException{
    public NoUserException(long id) {
        super("User  " + id + " is not registered in the Database. Please check the ID.");
    }
}
