package se.kth.iv1350.seminar3processsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminar3processsale.dto.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {
    private InventorySystem instanceInvSystem;


    @BeforeEach
    void setUp() {
        instanceInvSystem = new InventorySystem();
    }

    @AfterEach
    void tearDown() {
        instanceInvSystem = null;
    }

    @Test
    void testGetCorrectItemDescription() {
        String ItemDescription = (instanceInvSystem.getItemInfo(123)).getItemDescription();
        String expectedItemDescription = "Milk\t\t\t";
        boolean similarityBetweenItems = ItemDescription.equals(expectedItemDescription);
        assertTrue(similarityBetweenItems);
    }

    @Test
    void testGetWrongItemDescription() {
        String ItemDescription =(instanceInvSystem.getItemInfo(123)).getItemDescription();
        String unexpectedItemDescription = "Strawberry\t\t";
        boolean differenceBetweenItems = ItemDescription.equals(unexpectedItemDescription);
        assertFalse(differenceBetweenItems);
    }
    @Test
    void testSameItemExistTwice() {
        String ItemDescription1 = (instanceInvSystem.getItemInfo(123)).getItemDescription();
        String ItemDescription2 = (instanceInvSystem.getItemInfo(1234)).getItemDescription();
        boolean similiarDescriptionTwice = ItemDescription1.equals(ItemDescription2);
        assertFalse(similiarDescriptionTwice);
    }
}