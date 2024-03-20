package vendingmachine.ui;

import java.util.HashMap;

public class View {
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu"); // todo: fix menu

        io.print("6. Quit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public void printVendingMachineSelection(HashMap vendingMachine){
        // for each loop for all vending machine items.
    }

}
