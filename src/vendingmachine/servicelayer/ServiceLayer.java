package vendingmachine.servicelayer;

import vendingmachine.dto.Item;

import java.util.List;

public interface ServiceLayer {
    List<Item> getAllItems() throws NoItemInventoryException;

    Item getItem(int identifier) throws NoItemInventoryException, InvalidIdentifierException, InsufficientFundsException;

    double getMoney();

    double incrementBalance(double moneyToBeAdded) throws InvalidMoneyInputException;

    double updateBalance(double newBalance) throws InsufficientFundsException, NoItemInventoryException;

    public void decrementInventory(Item item);

}