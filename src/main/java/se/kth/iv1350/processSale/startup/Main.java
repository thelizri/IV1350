package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.CustomerDatabase;
import se.kth.iv1350.processSale.integration.InventorySystem;
import se.kth.iv1350.processSale.view.View;

public class Main {
    public static void main(String[] args){
        AccountingSystem accountingSystem = new AccountingSystem();
        InventorySystem inventorySystem = new InventorySystem();
        CustomerDatabase customerDatabase = new CustomerDatabase();
        Controller controller = new Controller(accountingSystem, inventorySystem, customerDatabase);
        View view = new View(controller);
        view.runDummyProgram();
    }
}
