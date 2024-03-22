package vendingmachine.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vendingmachine.dto.Item;

import java.util.HashMap;
import java.util.List;
@Component
public class View {
    @Autowired
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
    public void printVendingMachineItem(Item item){
        // for each loop for all vending machine items
        io.print(item.getIdentifier() + ". " + item.getItemName() + " costs: " + item.getItemCost());
    }
    public void displayBye() {
        io.print("GOOD BYE");
    }


    public double getMoneyToBeAdded() {
        return io.readDouble("How much would you like to deposit?");
    }
    public void displayCurrentBalance(double currentBalance) {
        io.print("Your current balance is now: " + currentBalance);
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

    public void displayVendedItem(String itemName) {
        io.print("Enjoy your " + itemName);
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command");
    }
}