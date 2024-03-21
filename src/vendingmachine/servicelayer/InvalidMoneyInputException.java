package vendingmachine.servicelayer;

public class InvalidMoneyInputException extends Exception {
    public InvalidMoneyInputException(String message) {
        super(message);
    }

    public InvalidMoneyInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
