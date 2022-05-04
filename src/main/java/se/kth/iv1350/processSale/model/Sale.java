package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Printer;

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

    public Receipt endSale(){
        String text = "Receipt:\n";
        text+="Total Price: "+totalPrice+"\n";
        text+="Total VAT: "+totalVAT+"\n";
        text+="Discount: "+discountAmount+"\n";
        text+="Paid: "+paidAmount+"\n";
        text+="Change: "+change+"\n";

        for(int i=0;i<shoppingCart.size();i++){
            Item currentItem = shoppingCart.get(i);
            text += currentItem.getDescription()+" "+currentItem.getQuantity()+"\n";
        }
        text+="End of receipt";
        return new Receipt(text);
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
