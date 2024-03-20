package vendingmachine.dao;

import vendingmachine.dto.Item;

import java.util.List;

public interface Dao {

    Item addItem(Item item, int inventoryLevel);

    List<Item> getAllItems();

    Item getItem(String itemName);

    Item removeItem(String itemName);

}
