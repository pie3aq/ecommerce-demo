package main.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    void testCategoryEnumValues() {
        assertNotNull(Category.CLOTHING);
        assertNotNull(Category.FOOTWEAR);
        assertNotNull(Category.BACKPACKS);
        assertNotNull(Category.TENTS);
        assertNotNull(Category.CLIMBING_GEAR);
        assertNotNull(Category.LIGHTING);
        assertNotNull(Category.CAMP_KITCHEN);
        assertNotNull(Category.ELECTRONICS);
    }

    @Test
    void testCategoryEnumCount() {
        assertEquals(8, Category.values().length);
    }

    @Test
    void testCategoryEnumToString() {
        assertEquals("CLOTHING", Category.CLOTHING.toString());
        assertEquals("CAMP_KITCHEN", Category.CAMP_KITCHEN.toString());
    }
}

