package se.kth.iv1350.processSale.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {

    @Test
    void getItemDescription() {
        InventorySystem inventory = new InventorySystem();
        assertEquals("Milk",inventory.getItemDescription(1),
                "Wrong item description");
        assertEquals("Eggs",inventory.getItemDescription(2),
                "Wrong item description");
        assertEquals("Bacon",inventory.getItemDescription(3),
                "Wrong item description");
        assertEquals("Apple Juice",inventory.getItemDescription(4),
                "Wrong item description");
        assertEquals("Pasta",inventory.getItemDescription(5),
                "Wrong item description");
    }
}