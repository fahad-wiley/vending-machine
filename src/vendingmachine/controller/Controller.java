package vendingmachine.controller;

import vendingmachine.dao.Dao;
import vendingmachine.dao.DaoFileImpl;
import vendingmachine.dto.Item;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.View;

import java.util.List;


public class Controller {
    private View view = new View();
    private UserIO io = new UserIOConsoleImpl();
    private Dao dao = new DaoFileImpl();

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

    public void viewVendingMachineContents() {
        view.displayBannerVendingMachine();
        for (Item item : dao.getAllItems()) {
            view.printVendingMachineItem(item);
        }
    }
    public void viewMenuSelection() {
        view.displayBannerMenuSelection();
        view.printMenuSelection();
    }

    public List<Item> getVendingMachineItems() {
        return dao.getAllItems();
    }

    public void addMoney() {
        view.displayBannerAddMoney();
        double money = view.getMoneyToBeAdded();
        double newBalance = dao.incrementBalance(money);
        view.displayCurrentBalance(newBalance);
    }

    private void vendItem() {
        view.displayBannerVendItem();
        int chosenIdenitfier = view.getVendingSelection();
        // TODO: check valid vending option input
        Item chosenItem = dao.getItem(chosenIdenitfier);
        dao.decrementInventory(chosenItem);
        view.displayVendedItem(chosenItem.getItemName());
        double newBalance = (dao.getMoney())-(chosenItem.getItemCost());
        dao.updateBalance(newBalance);
        view.displayCurrentBalance(dao.getMoney());
    }
}