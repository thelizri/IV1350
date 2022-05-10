package se.kth.iv1350.processSale.model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.integration.InventorySystem;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void testEquals() {
        InventorySystem inventorySystem = new InventorySystem();
        //First test
        Item expected = inventorySystem.getItem(1,2);
        Item actual = inventorySystem.getItem(1,2);
        assertEquals(expected,actual,"Objects are not equal");

        //Second test
        actual = inventorySystem.getItem(2,2);
        assertNotEquals(expected,actual,"Objects are equal");

        //Third test
        actual = inventorySystem.getItem(1,3);
        assertNotEquals(expected,actual,"Objects are equal");
    }
}