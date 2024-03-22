package vendingmachine.dto;

public class Item {
    public static int currentIdentifier = 1;
    private String itemName;
    private double itemCost; // todo: CHANGE TO BIG DECIMAL
    private int identifier;
    public String getItemName() {
        return itemName;
    }

    public Item(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.identifier = currentIdentifier++;
    }

    public void setItemName(String itemName) { // todo: POTENTIALLY REMOVE LATER
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
}
