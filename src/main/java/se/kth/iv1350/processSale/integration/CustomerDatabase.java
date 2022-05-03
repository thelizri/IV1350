package se.kth.iv1350.processSale.integration;

public class CustomerDatabase {
    public CustomerDatabase() {
    }
    public boolean verifyCustomer(int customerID){
        return true;
    }

    public String getName(int customerID){
        return "Name";
    }

    public String getAddress(int customerID){
        return "Address";
    }

    public void registerNewCustomer(String name, String address, int customerID){

    }
}
