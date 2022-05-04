package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sale {
    private int totalPrice;
    private int totalVAT;
    private int discountAmount;
    private int paidAmount;
    private int change;
    private List<Item> shoppingCart;

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

    @Override
    public int hashCode() {
        return Objects.hash(totalPrice, totalVAT, discountAmount, paidAmount, change);
    }

    public Sale() {
        this.totalPrice = 0;
        this.totalVAT = 0;
        this.discountAmount = 0;
        this.paidAmount = 0;
        this.change = 0;
        this.shoppingCart = new ArrayList<>();
    }

    public void addItem(int itemIdentifier, int quantity){
        shoppingCart.add(new Item(itemIdentifier,quantity));
    }

    public void applyDiscount(Discount discount){
        discountAmount = discount.getDiscountAmount();
    }

    public boolean pay(int amount){
        calculateTotalPrice();
        paidAmount += amount;
        if(paidAmount>=totalPrice){
            change = paidAmount-totalPrice;
            return true;
        }
        return false;
    }

    public int getRemainingAmountToPay(){
        calculateTotalPrice();
        return totalPrice-paidAmount;
    }
    
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

    public int getTotalPrice(){
        calculateTotalPrice();
        return this.totalPrice;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public int getTotalVAT() {
        return totalVAT;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getChange() {
        return change;
    }

    public List<Item> getShoppingCart() {
        return shoppingCart;
    }
}
