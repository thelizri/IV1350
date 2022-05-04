package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.InventorySystem;

import java.util.Objects;

public class Item {
    private int itemIdentifier;
    private int price;
    private int VAT;
    private int quantity;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemIdentifier == item.itemIdentifier && price == item.price
                && VAT == item.VAT && quantity == item.quantity
                && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIdentifier, price, VAT, quantity, description);
    }

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
