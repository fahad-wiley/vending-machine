package vendingmachine.dao;

import vendingmachine.dto.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaoFileImpl implements Dao {

    private HashMap<Item, Integer> vendingMachine = new HashMap<>();
    private double vendingMachineBalance = 0;

    public DaoFileImpl() {
        Item coke = new Item("Coke", 2);
        vendingMachine.put(coke, 5);

        Item dairyMilk = new Item("Dairy Milk", 1);
        vendingMachine.put(dairyMilk, 6);

        Item skittles = new Item("Skittles", 2);
        vendingMachine.put(skittles, 7);
    }

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
    public Item getItem(int identifier) {
        for(Item item : vendingMachine.keySet()) {
            if(item.getIdentifier() == identifier) return item;
        }
        return null;
    }

    @Override
    public Item removeItem(String itemName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getMoney() {
        return vendingMachineBalance;
    }

    @Override
    public double setMoney(double moneyToBeAdded) {
        vendingMachineBalance += moneyToBeAdded;
        return vendingMachineBalance;
    }

    public void decrementInventory(int identifier) {
        getItem()
    }


}
