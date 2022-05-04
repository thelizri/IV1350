package test;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testEquals() {
        //First test
        Item expected = new Item(1,2);
        Item actual = new Item(1,2);
        assertEquals(expected,actual,"Objects are not equal");

        //Second test
        actual = new Item(2,2);
        assertNotEquals(expected,actual,"Objects are equal");

        //Third test
        actual = new Item(1,3);
        assertNotEquals(expected,actual,"Objects are equal");
    }
}