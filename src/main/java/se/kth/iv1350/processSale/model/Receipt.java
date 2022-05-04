package se.kth.iv1350.processSale.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Creates receipts from purchases.
 */
public class Receipt {
    private String receiptText;
    private Sale sale;

    /**
     * Creates an instance of the Receipt class.
     * @param sale An instance of a sale.
     */
    public Receipt(Sale sale){
        this.sale = sale;
        receiptText = "";
        addDateToReceipt();
        addItemsToReceipt();
        addAmountsToReceipt();
    }

    /**
     * Returns all the text that should be printed on the receipt.
     * @return The receipt text.
     */
    @Override
    public String toString() {
        return receiptText;
    }

    private void addDateToReceipt(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        receiptText += "Date: "+formattedDate+"\n";
    }

    private void addItemsToReceipt(){
        List<Item> items = sale.getShoppingCart();
        for(int i=0;i< items.size();i++){
            receiptText += items.get(i).getQuantity()+", "
                    +items.get(i).getDescription()+" "
                    +items.get(i).getPrice()+"kr\n";
        }
    }

    private void addAmountsToReceipt(){
        receiptText += "Paid Amount: "+sale.getPaidAmount()+"\n";
        receiptText += "Change: "+sale.getChange()+"\n";
        receiptText += "Discount: "+sale.getDiscountAmount()+"\n";
        receiptText += "Total Price: "+sale.getTotalPrice()+"\n";
        receiptText += "Total VAT: "+sale.getTotalVAT()+"\n";
    }
}
