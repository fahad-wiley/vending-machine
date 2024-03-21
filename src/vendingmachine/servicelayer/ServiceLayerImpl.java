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
    public Item getItem(int identifier) throws NoItemInventoryException {
        int inventoryNumber = dao.getInventoryLevel(identifier);
        if (inventoryNumber <= 0) {
            throw new NoItemInventoryException("Item out of stock.");
        }
        return dao.getItem(identifier);
    }

    @Override
    public double getMoney() {
        return 0;
    }

    @Override
    public double incrementBalance(double moneyToBeAdded) throws InvalidMoneyInputException {
        if (moneyToBeAdded < 0) {
            throw new InvalidMoneyInputException("Cannot add negative amount.");
        }
        return dao.incrementBalance(moneyToBeAdded);
    }

    @Override
    public double updateBalance(double newBalance) throws InsufficientFundsException, NoItemInventoryException {
        return 0;
    }

    @Override
    public void decrementInventory(Item item) {
    }
}
