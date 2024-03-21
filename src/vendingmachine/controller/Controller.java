package vendingmachine.controller;

import vendingmachine.dao.Dao;
import vendingmachine.dao.DaoFileImpl;
import vendingmachine.dto.Item;
import vendingmachine.servicelayer.InvalidMoneyInputException;
import vendingmachine.servicelayer.NoItemInventoryException;
import vendingmachine.servicelayer.ServiceLayer;
import vendingmachine.servicelayer.ServiceLayerImpl;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.View;

import java.util.List;


public class Controller {
    private View view = new View();
    private UserIO io = new UserIOConsoleImpl();
    private ServiceLayer service = new ServiceLayerImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            viewVendingMachineContents();
            viewMenuSelection();
            menuSelection = view.getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addMoney();
                    break;
                case 2:
                    vendItem();
                    break;
                case 3:
                    keepGoing=false;
                    break;
                default:
                    view.displayUnknownCommand();
            }
        }
        view.displayBye();
    }

    public void viewVendingMachineContents() throws NoItemInventoryException {
        view.displayBannerVendingMachine();
        for (Item item : service.getAllItems()) {
            view.printVendingMachineItem(item);
        }
    }
    public void viewMenuSelection() {
        view.displayBannerMenuSelection();
        view.printMenuSelection();
    }

    public List<Item> getVendingMachineItems() throws NoItemInventoryException {
        return service.getAllItems();
    }

    public void addMoney() throws InvalidMoneyInputException {
        view.displayBannerAddMoney();
        double money = view.getMoneyToBeAdded();
        double newBalance = service.incrementBalance(money);
        view.displayCurrentBalance(newBalance);
    }

    private void vendItem() throws NoItemInventoryException {
        view.displayBannerVendItem();
        int chosenIdenitfier = view.getVendingSelection();
        // TODO: check valid vending option input
        Item chosenItem = service.getItem(chosenIdenitfier);
        dao.decrementInventory(chosenItem);
        view.displayVendedItem(chosenItem.getItemName());
        double newBalance = (dao.getMoney())-(chosenItem.getItemCost());
        dao.updateBalance(newBalance);
        view.displayCurrentBalance(dao.getMoney());
    }
}