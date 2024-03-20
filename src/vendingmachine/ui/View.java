package vendingmachine.ui;

import vendingmachine.dto.Item;

import java.util.HashMap;
import java.util.List;

public class View {
    private UserIO io = new UserIOConsoleImpl();

    public void printMenuSelection() {
        io.print("1. Add Money");
        io.print("2. Vend Item");
        io.print("3. Quit");
    }
    public int getMenuSelection() {
        return io.readInt("Please select from the"
                + " above choices.", 1, 3);
    }
    public void displayBannerMenuSelection() {
        io.print("=== Menu Selection ===");
    }
    public void displayBannerVendingMachine() {
        io.print("=== Vending Machine ===");
    }
    public void printVendingMachineSelection(List<Item> vendingMachine){
        // for each loop for all vending machine items
        for(Item item : vendingMachine) {
            io.print(item.getIdentifier() + ". " + item.getItemName() + " costs: " + item.getItemCost());
        } // TODO: order identifiers
    }
    public void displayBye() {
        io.print("GOOD BYE");
    }


    public double getMoneyToBeAdded() {
        return io.readDouble("How much would you like to deposit?");
    }
    public void displayCurrentBalance(double currentBalance) {
        io.print("Your current balance is : " + currentBalance);
    }
    public void displayBannerAddMoney() {
        io.print("=== Add Money ===");
    }
    public void displayBannerVendItem() {
        io.print("=== Vend Item ===");
    }

    public int getVendingSelection() {
        return io.readInt("Choose your item.");
    }
}