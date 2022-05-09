package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the sale: the total price, all the items in the shopping cart, any discounts.
 */
public class Sale {
    private int totalPrice;
    private int totalVAT;
    private int discountAmount;
    private int paidAmount;
    private int change;
    private List<Item> shoppingCart;

    /**
     * Tests if this instance of Sale is equal to another instance of this same class.
     * @param o An instance of another object.
     * @return The true/false value that is the result.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        boolean primitive_attributes_comparison = (totalPrice == sale.totalPrice && totalVAT == sale.totalVAT
                && discountAmount == sale.discountAmount && paidAmount == sale.paidAmount
                && change == sale.change);

        //A loop that goes through the shopping list and checks that they are all the same
        boolean object_attributes_comparison = false;
        if(shoppingCart.size()==sale.shoppingCart.size()){
            object_attributes_comparison = true;
            for(int i=0;i<shoppingCart.size();i++){
                Item item = shoppingCart.get(i);
                if(!item.equals(sale.shoppingCart.get(i))){
                    object_attributes_comparison = false;
                    break;
                }
            }
        }

        return primitive_attributes_comparison && object_attributes_comparison;
    }

    /**
     * Creates a new instance of Sale.
     */
    public Sale() {
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.discountAmount = 0;
        this.paidAmount = 0;
        this.change = 0;
        this.shoppingCart = new ArrayList<>();
    }

    /**
     * Adds items to the sale.
     * @param itemIdentifier The identifier of the item.
     * @param quantity The quantity of the item to be added.
     */
    public void addItem(int itemIdentifier, int quantity){
        shoppingCart.add(new Item(itemIdentifier,quantity));
    }

    /**
     * Applies discount to this sale.
     * @param discount The discount being applied to the sale.
     */
    public void applyDiscount(Discount discount){
        discountAmount = discount.getDiscountAmount();
    }

    /**
     * Pays money that is due for the sale. Will return true if payment is complete.
     * @param amount The amount being paid.
     * @return True/false value that tells whether or not the payment is complete.
     */
    public boolean pay(int amount){
        calculateTotalPrice();
        paidAmount += amount;
        if(paidAmount>=totalPrice){
            change = paidAmount-totalPrice;
            return true;
        }
        return false;
    }

    /**
     * Returns the remaining amount that needs to be paid.
     * @return The remaining amount that needs to be paid.
     */
    public int getRemainingAmountToPay(){
        calculateTotalPrice();
        return totalPrice-paidAmount;
    }

    /**
     * Ends the sale and returns a receipt for it.
     * @return The receipt of the sale.
     */
    public Receipt endSaleAndReturnReceipt(){
        Receipt receipt = new Receipt(this);
        return receipt;
    }

    private void calculateTotalPrice(){
        this.totalPrice = 0;
        this.totalVAT = 0;
        for(int i=0; i<shoppingCart.size();i++){
            Item x = shoppingCart.get(i);
            totalPrice += x.getPrice()*x.getQuantity();
            totalVAT += x.getVAT()* x.getQuantity();
        }
        totalPrice -= discountAmount;
    }

    /**
     * Returns the total price of the sale/purchase.
     * @return The total price.
     */
    public int getTotalPrice(){
        calculateTotalPrice();
        return this.totalPrice;
    }

    /**
     * Returns the amount that has been paid by the customer so far.
     * @return The amount that has been paid.
     */
    public int getPaidAmount() {
        return paidAmount;
    }

    /**
     * Returns the total VAT for the purchase.
     * @return The total VAT.
     */
    public int getTotalVAT() {
        return totalVAT;
    }

    /**
     * Returns the amount of applied discount. Returns 0 if there is no discount.
     * @return The discount amount.
     */
    public int getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Returns the amount of change the customer is supposed to receive at the end of the purchase.
     * @return The amount of change.
     */
    public int getChange() {
        return change;
    }

    /**
     * Returns a list with all the items in the shopping cart.
     * @return A <code>List</> of <code>Item</>.
     */
    public List<Item> getShoppingCart() {
        return shoppingCart;
    }
}
