package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.*;
import se.kth.iv1350.processSale.model.*;

/**
 * This is the controller class. It's responsible for a lot of the logic of the program.
 * Making sure the right methods are called and the right classes are used.
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private CustomerDatabase customerDatabase;
    private DiscountDatabase discountDatabase;
    private Sale currentSale;
    private Customer customer;
    private Discount discount;

    /**
     * Creates an instance of the controller class.
     * @param accountingSystem An instance of the accounting system.
     * @param inventorySystem An instance of the inventory system.
     * @param customerDatabase An instance of the customer database.
     * @param discountDatabase An instance of the discount database.
     */
    public Controller(AccountingSystem accountingSystem, InventorySystem inventorySystem,
                      CustomerDatabase customerDatabase, DiscountDatabase discountDatabase) {
        this.customerDatabase = customerDatabase;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.discountDatabase = discountDatabase;
    }

    /**
     * Creates a new sale.
     */
    public void createNewSale(){
        currentSale = new Sale();
    }

    /**
     * Scans an item's identifier. Adds the item to the sale.
     * @param itemIdentifier The item identifier.
     * @param quantity The quantity of the item.
     * @return The sale.
     */
    public Sale scanItem(int itemIdentifier, int quantity){
        if(inventorySystem.verifyItem(itemIdentifier)){
            Item item = inventorySystem.getItem(itemIdentifier, quantity);
            currentSale.addItem(item);
        }
        return currentSale;
    }

    /**
     * Applies discount to sale. If the customer is not eligible for a discount, it returns false.
     * @param customerID The ID of the customer.
     * @return true/false value.
     */
    public boolean discountRequest(int customerID){
        if(customerDatabase.verifyCustomer(customerID)){
            customer = customerDatabase.getCustomer(customerID);
            discount = discountDatabase.getDiscount(customer);
            currentSale.applyDiscount(discount);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Creates a new customer and registers him/her to the customer database.
     * @param name The name of the customer.
     * @param address The address of the customer.
     * @param customerID The customer ID.
     */
    public void registerNewCustomer(String name, String address, int customerID){
        customer = new Customer(name, address, customerID);
        customerDatabase.registerNewCustomer(customer);
    }

    /**
     * Makes payment for sale. Returns false if payment is incomplete.
     * @param amount The amount the customer pays in.
     * @return true/false value.
     */
    public boolean pay(int amount){
        boolean result = currentSale.pay(amount);
        return result;
    }

    /**
     * Ends the sale. Calls the printer that prints the receipt. Updates the inventory system
     * and accounting system.
     */
    public void endSale(){
        Receipt receipt = currentSale.endSaleAndReturnReceipt();
        Printer printer = new Printer();
        printer.printReceipt(receipt);
        accountingSystem.registerSale(currentSale);
        inventorySystem.updateInventory(currentSale);
    }
}
