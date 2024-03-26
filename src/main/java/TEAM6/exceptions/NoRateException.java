package TEAM6.exceptions;

public class NoRateException extends  RuntimeException{
     public NoRateException(long id) {
        super("Warning! Rate " + id + " ID doesn't exist!");
    }
}
