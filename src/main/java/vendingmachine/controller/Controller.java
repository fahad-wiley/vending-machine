package vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vendingmachine.dao.Dao;
import vendingmachine.dao.DaoFileImpl;
import vendingmachine.dto.Item;
import vendingmachine.servicelayer.*;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.View;

import java.util.List;

@Component
public class Controller {
    @Autowired
    private View view = new View();
    @Autowired
    private UserIO io = new UserIOConsoleImpl();
    @Autowired
    private ServiceLayer service = new ServiceLayerImpl();

    public void run() throws InvalidMoneyInputException, NoItemInventoryException, InvalidIdentifierException, InsufficientFundsException {
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

    private void vendItem() throws NoItemInventoryException, InvalidIdentifierException, InsufficientFundsException {
        view.displayBannerVendItem();
        int chosenIdenitfier = view.getVendingSelection();
        // TODO: check valid vending option input
        Item chosenItem = service.getItem(chosenIdenitfier);
        service.decrementInventory(chosenItem);
        view.displayVendedItem(chosenItem.getItemName());
        double newBalance = (service.getMoney())-(chosenItem.getItemCost());
        service.updateBalance(newBalance);
        view.displayCurrentBalance(service.getMoney());
    }
}