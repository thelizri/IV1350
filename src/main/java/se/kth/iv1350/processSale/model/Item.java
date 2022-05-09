package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.InventorySystem;

import java.util.Objects;

/**
 * Stores information about an item: quantity, tag, price, VAT, description.
 */
public class Item {
    private int itemIdentifier;
    private int price;
    private int VAT;
    private int quantity;
    private String description;

    /**
     * Test if another instance of Item is equal to this instance.
     * @param o Instance of an Object
     * @return true/false value.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemIdentifier == item.itemIdentifier && price == item.price
                && VAT == item.VAT && quantity == item.quantity
                && description.equals(item.description);
    }

    /**
     * Creates an instance of the Item class.
     * @param itemIdentifier The tag of the item.
     * @param quantity Quantity of the item.
     */
    public Item(int itemIdentifier, int quantity) {
        InventorySystem inventorySystem = new InventorySystem();
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
        this.price = inventorySystem.getPrice(itemIdentifier);
        this.VAT = inventorySystem.getVAT(itemIdentifier);
        this.description = inventorySystem.getItemDescription(itemIdentifier);
    }

    /**
     * Returns the price of a single unit of the item.
     * @return The price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the VAT of a single unit of the item.
     * @return The VAT of the item.
     */
    public int getVAT() {
        return VAT;
    }

    /**
     * Returns a description of the item.
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the quantity of the item.
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

}
