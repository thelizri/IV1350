package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CustomerDatabase;

public class Customer {
    private int customerID;
    private String name;
    private String address;

    /**
     * Creates an instance of Customer. Registers the new customer to
     * the CustomerDatabase.
     * @param name A String with the name of the customer
     * @param address Address of the customer
     * @param customerID The customer ID number
     */
    public Customer(String name, String address, int customerID){
        this.name = name;
        this.address = address;
        this.customerID = customerID;
        CustomerDatabase customerDatabase = new CustomerDatabase();
        customerDatabase.registerNewCustomer(name,address,customerID);
    }

    /**
     * Creates an instance of a Customer.
     * @param customerID The customer ID number.
     */
    public Customer(int customerID) {
        CustomerDatabase customerDatabase = new CustomerDatabase();
        this.customerID = customerID;
        this.name = customerDatabase.getName(customerID);
        this.address = customerDatabase.getAddress(customerID);
    }

    /**
     * Returns the name of the customer.
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the customer.
     * @return The address of the customer.
     */
    public String getAddress() {
        return address;
    }
}
