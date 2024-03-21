package vendingmachine.servicelayer;

import vendingmachine.dao.Dao;
import vendingmachine.dao.DaoFileImpl;
import vendingmachine.dto.Item;

import java.util.List;

public class ServiceLayerImpl implements ServiceLayer {

    Dao dao = new DaoFileImpl();

    @Override
    public List<Item> getAllItems() throws NoItemInventoryException {
        return dao.getAllItems(); //todo: file persistence exceptions
    }

    @Override
    public Item getItem(int identifier) throws NoItemInventoryException, InvalidIdentifierException, InsufficientFundsException {
        if(identifier < 1 || identifier > Item.currentIdentifier-1){
            throw new InvalidIdentifierException("That's an invalid identifier.");
        }
        int inventoryNumber = dao.getInventoryLevel(identifier);
        if (inventoryNumber <= 0) {
            throw new NoItemInventoryException("Item out of stock.");
        }
        if(dao.getVendingMachineBalance() < dao.getItem(identifier).getItemCost()){
            throw new InsufficientFundsException("Not enough money.");
        }
        return dao.getItem(identifier);
    }

    @Override
    public double getMoney() {
        return dao.getMoney();
    }

    @Override
    public double incrementBalance(double moneyToBeAdded) throws InvalidMoneyInputException {
        if (moneyToBeAdded < 0) {
            throw new InvalidMoneyInputException("Cannot add negative amount.");
        }
        return dao.incrementBalance(moneyToBeAdded);
    }

    @Override
    public double updateBalance(double newBalance) {
        return dao.updateBalance(newBalance);
    }

    @Override
    public void decrementInventory(Item item) {
        dao.decrementInventory(item);
    }
}
