package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.CustomerDatabase;
import se.kth.iv1350.processSale.integration.InventorySystem;
import se.kth.iv1350.processSale.model.Customer;
import se.kth.iv1350.processSale.model.Discount;
import se.kth.iv1350.processSale.model.Sale;

public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private CustomerDatabase customerDatabase;
    private Sale currentSale;
    private Customer customer;
    private Discount discount;

    public Controller(AccountingSystem accountingSystem, InventorySystem inventorySystem,
                      CustomerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
    }

    public void createNewSale(){
        currentSale = new Sale();
    }

    public void scanItem(int itemIdentifier, int quantity){
        if(inventorySystem.verifyItem(itemIdentifier)){
            currentSale.addItem(itemIdentifier, quantity);
        }
    }

    public boolean discountRequest(int customerID){
        if(customerDatabase.verifyCustomer(customerID)){
            customer = new Customer(customerID);
            discount = new Discount(customer);
            currentSale.applyDiscount(discount);
            return true;
        }
        else{
            return false;
        }
    }

    public void createNewCustomer(String name, String address, int customerID){
        customer = new Customer(name, address, customerID);
    }

    public void pay(){

    }

    public void endSale(){

    }
}
