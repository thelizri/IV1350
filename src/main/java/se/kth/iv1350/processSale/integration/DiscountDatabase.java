package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Customer;

public class DiscountDatabase {
    public DiscountDatabase() {
    }
    public boolean verifyDiscount(Customer customer){
        return true;
    }
    public int getDiscountAmount(Customer customer){
        return 0;
    }
}
