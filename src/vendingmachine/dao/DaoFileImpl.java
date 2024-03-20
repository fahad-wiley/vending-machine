package vendingmachine.dao;

import vendingmachine.dto.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaoFileImpl implements Dao {

    private HashMap<Item, Integer> vendingMachine = new HashMap<>();

    @Override
    public Item addItem(Item item, int inventoryLevel) {
        vendingMachine.put(item, inventoryLevel);
        return item;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        items.addAll(vendingMachine.keySet());
        return items;
    }

    @Override
    public Item getItem(String itemName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item removeItem(String itemName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
