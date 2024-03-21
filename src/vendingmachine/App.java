package vendingmachine;

import vendingmachine.controller.Controller;
import vendingmachine.servicelayer.InsufficientFundsException;
import vendingmachine.servicelayer.InvalidIdentifierException;
import vendingmachine.servicelayer.InvalidMoneyInputException;
import vendingmachine.servicelayer.NoItemInventoryException;

public class App {
    public static void main(String[] args) throws InvalidMoneyInputException, NoItemInventoryException, InvalidIdentifierException, InsufficientFundsException {
        Controller controller = new Controller();
        controller.run();
    }
}
