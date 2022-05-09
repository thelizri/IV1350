package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Receipt;

/**
 * The printer class is responsible for printing receipts.
 */
public class Printer {
    /**
     * Creates an instance of Printer.
     */
    public Printer() {
    }

    /**
     * Prints a Receipt.
     * @param receipt An instance of Receipt class.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt);
    }
}
