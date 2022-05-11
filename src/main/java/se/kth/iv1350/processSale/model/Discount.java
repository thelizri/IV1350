package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CustomerDatabase;
import se.kth.iv1350.processSale.integration.DiscountDatabase;

/**
 * This is the discount class. It contains information about the discount.
 */
public class Discount {
    private Customer customer;
    private DiscountDatabase database;
    private int discountAmount;

    /**
     * Creates an instance of the Discount class.
     * @param customer An instance of the customer class.
     * @param discountAmount The discount amount.
     */
    public Discount(Customer customer, int discountAmount){
        this.customer = customer;
        this.discountAmount = discountAmount;
    }

    /**
     * Gets the discount amount.
     * @return The discount amount.
     */
    public int getDiscountAmount() {
        return discountAmount;
    }
}
