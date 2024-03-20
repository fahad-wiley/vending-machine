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

    public List<Item> getVendingMachineItems(){
        return dao.getAllItems();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("5. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 5);

            switch (menuSelection) {
                case 1:
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
}
