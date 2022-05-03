package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.InventorySystem;

public class Item {
    private int itemIdentifier;
    private int price;
    private int VAT;
    private int quantity;
    private String description;

    public Item(int itemIdentifier, int quantity) {
        InventorySystem inventorySystem = new InventorySystem();
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
        this.price = inventorySystem.getPrice(itemIdentifier);
        this.VAT = inventorySystem.getVAT(itemIdentifier);
        this.description = inventorySystem.getItemDescription(itemIdentifier);
    }

    public int getPrice() {
        return price;
    }

    public int getVAT() {
        return VAT;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
