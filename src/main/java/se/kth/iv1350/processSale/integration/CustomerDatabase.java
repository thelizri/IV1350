package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Customer;

/**
 * This class represents the database containing all the customers.
 */
public class CustomerDatabase {
    /**
     * Creates an instance of CustomerDatabase.
     */
    public CustomerDatabase() {
    }

    /**
     * Verifies that a customer exist in the database.
     * @param customerID The ID number of the customer.
     * @return true/false value.
     */
    public boolean verifyCustomer(int customerID){
        return true;
    }

    /**
     * Returns a customer instance given a customer ID.
     * @param customerID The customer ID.
     * @return The customer instance.
     */
    public Customer getCustomer(int customerID){
        String customerName = getName(customerID);
        String customerAddress = getAddress(customerID);
        return new Customer(customerName, customerAddress, customerID);
    }

    /**
     * Adds a new customer to the database.
     * @param customer The customer.
     */
    public void registerNewCustomer(Customer customer){

    }

    private String getName(int customerID){
        return "Johnny Depp";
    }

    private String getAddress(int customerID){
        return "Hollywood";
    }
}
