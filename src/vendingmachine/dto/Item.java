package vendingmachine.dto;

public class Item {
    private String itemName;
    private double itemCost; // todo: CHANGE TO BIG DECIMAL


    public String getItemName() {
        return itemName;
    }

    public Item(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public void setItemName(String itemName) { // todo: POTENTIALLY REMOVE LATER
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
}
