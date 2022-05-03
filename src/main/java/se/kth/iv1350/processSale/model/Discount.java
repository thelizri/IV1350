package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CustomerDatabase;
import se.kth.iv1350.processSale.integration.DiscountDatabase;

public class Discount {
    private Customer customer;
    private DiscountDatabase database;
    private int discountAmount;
    public Discount(Customer customer){
        this.customer = customer;
        this.database = new DiscountDatabase();
    }

    public boolean verifyDiscount(){
        if(database.verifyDiscount(customer)){
            database.getDiscountAmount(customer);
            return true;
        }
        return false;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
