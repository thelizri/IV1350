package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Sale;

public class InventorySystem {
    public InventorySystem() {
    }

    public void updateInventory(Sale sale){

    }

    public boolean verifyItem(int itemIdentifier){
        return true;
    }

    public String getItemDescription(int itemIdentifier){
        return "Hello";
    }

    public int getPrice(int itemIdentifier){
        return 0;
    }

    public int getVAT(int itemIdentifier){
        return 0;
    }
}
