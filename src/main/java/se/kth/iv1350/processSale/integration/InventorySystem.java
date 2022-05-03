package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Sale;

public class InventorySystem {
    public InventorySystem() {
    }

    public void updateInventory(Sale sale){

    }

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

    public String getItemDescription(int itemIdentifier){
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

    public int getPrice(int itemIdentifier){
        return 10;
    }

    public int getVAT(int itemIdentifier){
        return 1;
    }
}
