package vendingmachine.dao;

import org.springframework.stereotype.Component;
import vendingmachine.dto.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
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

    public double getVendingMachineBalance() {
        return vendingMachineBalance;
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
    public Integer getInventoryLevel(int identifier) {
        return vendingMachine.get(getItem(identifier));
    }

    @Override
    public double getMoney() {
        return vendingMachineBalance;
    }

    @Override
    public double incrementBalance(double moneyToBeAdded) {
        vendingMachineBalance += moneyToBeAdded;
        return vendingMachineBalance;
    }

    @Override
    public double updateBalance(double newBalance) {
        vendingMachineBalance = newBalance;
        return vendingMachineBalance;
    }

    public void decrementInventory(Item item) {
        vendingMachine.put(item, vendingMachine.get(item)-1);
    }


}
