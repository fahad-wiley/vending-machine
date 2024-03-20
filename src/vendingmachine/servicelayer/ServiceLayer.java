package vendingmachine.servicelayer;

import vendingmachine.dto.Item;

import java.util.List;

public interface ServiceLayer {
    Item addItem(Item item, int inventoryLevel);

    List<Item> getAllItems() throws NoItemInventoryException;

    Item getItem(int identifier) throws NoItemInventoryException;

    double getMoney();

    double incrementBalance(double moneyToBeAdded) throws InsufficientFundsException, NoItemInventoryException;

    double updateBalance(double newBalance) throws InsufficientFundsException, NoItemInventoryException;

    public void decrementInventory(Item item);

}
