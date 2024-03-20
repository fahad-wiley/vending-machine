package vendingmachine.controller;

import vendingmachine.dao.Dao;
import vendingmachine.dao.DaoFileImpl;
import vendingmachine.dto.Item;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.View;

import java.util.HashMap;
import java.util.List;

public class Controller {
    private View view = new View();
    private UserIO io = new UserIOConsoleImpl();

    private Dao dao = new DaoFileImpl();

    public void run() {
        initialViewing();

        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            view.printMenuAndGetSelection();
            menuSelection = view.getMenuSelection();

            switch (menuSelection) {
                case 1:
                    // add money
                    break;
                case 2:
                    // vend
                    break;
                case 3:
                    // exit
                    break;
                default:
                    // unknown command
            }

        }
        view.displayBye();
    }

    public void initialViewing() {
        view.displayBannerVendingMachine();
        view.printVendingMachineSelection(dao.getAllItems());
    }

    public List<Item> getVendingMachineItems() {
        return dao.getAllItems();
    }

    public void addMoney() {
        view.displayBannerAddMoney();
        double money = view.getMoneyToBeAdded();
        double newBalance = dao.setMoney(money);
        view.

    }

}