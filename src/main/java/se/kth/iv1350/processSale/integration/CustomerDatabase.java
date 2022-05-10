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
     * Returns the name of a customer.
     * @param customerID The ID number of the customer.
     * @return The name of the customer.
     */
    public String getName(int customerID){
        return "Johnny Depp";
    }

    /**
     * Returns the address of the customer.
     * @param customerID The ID number of the customer.
     * @return The address of the customer.
     */
    public String getAddress(int customerID){
        return "Hollywood";
    }

    /**
     * Adds a new customer to the database.
     * @param customer The customer.
     */
    public void registerNewCustomer(Customer customer){

    }
}
