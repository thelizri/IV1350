package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Customer;
import se.kth.iv1350.processSale.model.Discount;

/**
 * This is a database of  all the discounts.
 */
public class DiscountDatabase {
    /**
     * Creates an instance of the discount database.
     */
    public DiscountDatabase() {
    }

    /**
     * Verifies that there is exist a discount that can be applied
     * to the customer's purchase.
     * @param customer The customer
     * @return true/false value
     */
    public boolean verifyDiscount(Customer customer){
        return true;
    }

    /**
     * Returns an instance of discount given a customer.
     * @param customer The customer.
     * @return The discount.
     */
    public Discount getDiscount(Customer customer){
        int discountAmount = getDiscountAmount(customer);
        return new Discount(customer, discountAmount);
    }
    private int getDiscountAmount(Customer customer){
        return 2;
    }
}
