package vendingmachine.servicelayer;

import vendingmachine.dao.Dao;
import vendingmachine.dao.DaoFileImpl;
import vendingmachine.dto.Item;

import java.util.List;

public class ServiceLayerImpl implements ServiceLayer{

    Dao dao = new DaoFileImpl();

    @Override
    public Item addItem(Item item, int inventoryLevel) {
        return null;
    }

    @Override
    public List<Item> getAllItems() throws NoItemInventoryException {
        return null;
    }

    @Override
    public Item getItem(int identifier) throws NoItemInventoryException {
        return null;
    }

    @Override
    public double getMoney() {
        return 0;
    }

    @Override
    public double incrementBalance(double moneyToBeAdded) throws InsufficientFundsException, NoItemInventoryException {
        return 0;
    }

    @Override
    public double updateBalance(double newBalance) throws InsufficientFundsException, NoItemInventoryException {
        return 0;
    }

    @Override
    public void decrementInventory(Item item) {

    }
}
