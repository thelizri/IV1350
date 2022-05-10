package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Item;
import se.kth.iv1350.processSale.model.Sale;

/**
 * The inventory system. It keeps track of all the inventory and everything that's in storage.
 * It contains a database with prices, descriptions, and VAT of all items.
 */
public class InventorySystem {
    /**
     * Creates an instance of <code>InventorySystem<code/>.
     */
    public InventorySystem() {
    }

    /**
     * Updates the inventory after a sale.
     * @param sale The sale that has occured.
     */
    public void updateInventory(Sale sale){

    }

    /**
     * Verifies if an item identifier is correct and exist in the inventory system.
     * @param itemIdentifier The item identifier.
     * @return True/false value if the identifier is correct or not.
     */
    public boolean verifyItem(int itemIdentifier){
        boolean result = false;
        switch (itemIdentifier){
            case 1:
                result = true;
                break;
            case 2:
                result = true;
                break;
            case 3:
                result = true;
                break;
            case 4:
                result = true;
                break;
            case 5:
                result = true;
                break;
            default:
                result = false;
                break;
        }
        return result;
    }

    /**
     * Returns an object of type Item.
     * @param itemIdentifier The item identifier.
     * @param quantity The quantity of the item.
     * @return
     */
    public Item getItem(int itemIdentifier, int quantity){
        String itemDescription = getItemDescription(itemIdentifier);
        int price = getPrice(itemIdentifier);
        int VAT = getVAT(itemIdentifier);
        return new Item(itemIdentifier, quantity, price, VAT, itemDescription);
    }

    private String getItemDescription(int itemIdentifier){
        String result = "";
        switch (itemIdentifier){
            case 1:
                result = "Milk";
                break;
            case 2:
                result = "Eggs";
                break;
            case 3:
                result = "Bacon";
                break;
            case 4:
                result = "Apple Juice";
                break;
            case 5:
                result = "Pasta";
                break;
            default:
                result = "Unknown item";
                break;
        }
        return result;
    }

    private int getPrice(int itemIdentifier){
        return 10;
    }

    private int getVAT(int itemIdentifier){
        return 1;
    }
}
