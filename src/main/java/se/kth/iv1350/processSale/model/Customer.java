package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CustomerDatabase;

public class Customer {
    private int customerID;
    private String name;
    private String address;

    public Customer(String name, String address, int customerID){
        this.name = name;
        this.address = address;
        this.customerID = customerID;
        CustomerDatabase customerDatabase = new CustomerDatabase();
        customerDatabase.registerNewCustomer(name,address,customerID);
    }

    public Customer(int customerID) {
        CustomerDatabase customerDatabase = new CustomerDatabase();
        this.customerID = customerID;
        this.name = customerDatabase.getName(customerID);
        this.address = customerDatabase.getAddress(customerID);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
