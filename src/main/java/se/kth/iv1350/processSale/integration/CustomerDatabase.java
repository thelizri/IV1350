package se.kth.iv1350.processSale.integration;

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
     * @param name The name of the customer.
     * @param address The address of the customer.
     * @param customerID The ID number of the customer.
     */
    public void registerNewCustomer(String name, String address, int customerID){

    }
}
