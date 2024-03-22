package vendingmachine.servicelayer;

public class InvalidIdentifierException extends Exception{
    public InvalidIdentifierException(String message) {
        super(message);
    }

    public InvalidIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}
