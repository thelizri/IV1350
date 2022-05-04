package test;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void testEquals(){
        //First test
        Sale expected = new Sale();
        Sale actual = new Sale();
        assertEquals(expected, actual, "Objects are not equal");

        //Second test
        expected.addItem(1,2);
        actual.addItem(1,2);
        assertEquals(expected, actual, "Objects are not equal");

        //Third test
        actual.addItem(2,3);
        assertNotEquals(expected, actual, "Objects are equal");

    }

    @Test
    void addItem() {
        Sale expected = new Sale();
        expected.addItem(2,2);
        Sale actual = new Sale();
        actual.addItem(2,2);
        assertEquals(expected, actual, "The objects are equal");
    }

    @Test
    void applyDiscount() {
    }

    @Test
    void pay() {
    }

    @Test
    void getRemainingAmountToPay() {
    }

    @Test
    void endSale() {
    }
}