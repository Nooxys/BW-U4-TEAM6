package TEAM6.exceptions;

public class NoMaintenanceException extends  RuntimeException{
    public NoMaintenanceException(long id) {
        super("ERROR! The maintenance with " + id + " ID is not associated with any transport! please check the maintenance ID");
    }
}
