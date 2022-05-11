package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.CustomerDatabase;
import se.kth.iv1350.processSale.integration.DiscountDatabase;
import se.kth.iv1350.processSale.integration.InventorySystem;
import se.kth.iv1350.processSale.view.View;

/**
 * This is the main class.
 */
public class Main {

    /**
     * This is the main method. It's responsible for starting the program.
     * @param args The arguments passed in by the user during startup.
     */
    public static void main(String[] args){
        AccountingSystem accountingSystem = new AccountingSystem();
        InventorySystem inventorySystem = new InventorySystem();
        CustomerDatabase customerDatabase = new CustomerDatabase();
        DiscountDatabase discountDatabase = new DiscountDatabase();
        Controller controller = new Controller(accountingSystem, inventorySystem,
                customerDatabase, discountDatabase);
        View view = new View(controller);
        view.runDummyProgram();
    }
}
