package se.kth.iv1350.processSale.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int totalPrice;
    private int totalVAT;
    private int discountAmount;
    private int paidAmount;
    private int change;
    private List<Item> shoppingCart;

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
        if(discount.verifyDiscount()){
            discountAmount = discount.getDiscountAmount();
        }
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

    public Receipt endSale(){
        return new Receipt("Placehodler");
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
}
