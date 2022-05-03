package se.kth.iv1350.processSale.model;

public class Receipt {
    private String receiptText;
    public Receipt(String saleInfo) {
        receiptText = saleInfo;
    }

    @Override
    public String toString() {
        return receiptText;
    }
}
