package se.kth.iv1350.processSale.model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.integration.InventorySystem;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    @Test
    void testEquals(){
        InventorySystem inventorySystem = new InventorySystem();
        //First test
        Sale expected = new Sale();
        Sale actual = new Sale();
        assertEquals(expected, actual, "Objects are not equal");

        //Second test
        expected.addItem(inventorySystem.getItem(1,2));
        actual.addItem(inventorySystem.getItem(1,2));
        assertEquals(expected, actual, "Objects are not equal");

        //Third test
        actual.addItem(inventorySystem.getItem(2,3));
        assertNotEquals(expected, actual, "Objects are equal");

    }

    @Test
    void applyDiscount(){
        InventorySystem inventorySystem = new InventorySystem();

        Customer customer = new Customer(1);
        Discount discount = new Discount(customer);
        Sale sale = new Sale();
        sale.addItem(inventorySystem.getItem(1,3));
        sale.addItem(inventorySystem.getItem(1,2));
        //Total price for these wares is 50 kr
        sale.applyDiscount(discount);
        //Discount for all customers is 2 kr
        assertEquals(48,sale.getTotalPrice(),"Amount due is incorrect");
        assertEquals(48,sale.getRemainingAmountToPay(),"Amount due is incorrect");
        assertEquals(true, sale.pay(48), "Sale should be paid");
    }

    @Test
    void pay() {
        InventorySystem inventorySystem = new InventorySystem();
        //First test
        Sale sale = new Sale();
        sale.addItem(inventorySystem.getItem(1,2));
        sale.addItem(inventorySystem.getItem(2,3));
        //Total price for these items is 50 kr. All items cost 10 kr. 5*10 kr is 50 kr
        assertEquals(0,sale.getPaidAmount(), "Paid amount doesn't match what it should");

        //Second test
        assertEquals(50,sale.getTotalPrice(), "Price doesn't match what it should");

        //Third test
        assertEquals(false,sale.pay(30), "Says purchase is complete, even though it isn't");

        //Fourth test
        assertEquals(30,sale.getPaidAmount(), "Amount paid is incorrect");

        //Fifth test
        assertEquals(20,sale.getRemainingAmountToPay(), "Amount due is incorrect");

        //Sixth test
        assertEquals(true,sale.pay(20),"Purchase should be complete");
    }
}