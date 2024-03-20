package vendingmachine.dao;

import vendingmachine.dto.Item;

import java.util.List;

public interface Dao {

    Item addItem(Item item, int inventoryLevel);

    List<Item> getAllItems();

    Item getItem(int identifier);

    double getMoney();

    double incrementBalance(double moneyToBeAdded);

    double updateBalance(double newBalance);

    public void decrementInventory(Item item);
}