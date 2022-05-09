package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CustomerDatabase;
import se.kth.iv1350.processSale.integration.DiscountDatabase;

public class Discount {
    private Customer customer;
    private DiscountDatabase database;
    private int discountAmount;

    /**
     * Creates an instance of Discount
     * @param customer An instance of Customer
     */
    public Discount(Customer customer){
        this.customer = customer;
        this.database = new DiscountDatabase();
        getDiscountFromDatabase();
    }

    private void getDiscountFromDatabase(){
        if(database.verifyDiscount(customer)){
            this.discountAmount = database.getDiscountAmount(customer);
        }
        else{
            this.discountAmount = 0;
        }
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
