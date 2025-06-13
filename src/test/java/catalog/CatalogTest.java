package main.catalog;

import main.model.Category;
import main.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogTest {

    private Catalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new Catalog();
    }

    @Test
    void testGetAllProductsSortedByName() {
        List<String> products = catalog.getAllProductsSortedByName();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        // Verify sorting (simple check for a few elements)
        assertTrue(products.get(0).startsWith("2-Person Tent"));
        assertTrue(products.get(products.size() - 1).startsWith("Windshield for Stove"));
    }

    @Test
    void testGetAvailableProductsByCategorySortedByPrice() {
        List<String> clothingProducts = catalog.getAvailableProductsByCategorySortedByPrice(Category.CLOTHING);
        assertNotNull(clothingProducts);
        assertFalse(clothingProducts.isEmpty());
        assertEquals(1, clothingProducts.size());
        assertTrue(clothingProducts.get(0).startsWith("Waterproof Jacket"));

        List<String> campKitchenProducts = catalog.getAvailableProductsByCategorySortedByPrice(Category.CAMP_KITCHEN);
        assertNotNull(campKitchenProducts);
        assertFalse(campKitchenProducts.isEmpty());
        assertEquals(4, campKitchenProducts.size());
        assertTrue(campKitchenProducts.get(0).startsWith("Camping Cutlery Set"));
        assertTrue(campKitchenProducts.get(campKitchenProducts.size() - 1).startsWith("Titanium Pot"));

        List<String> electronicsProducts = catalog.getAvailableProductsByCategorySortedByPrice(Category.ELECTRONICS);
        assertNotNull(electronicsProducts);
        assertTrue(electronicsProducts.isEmpty()); // GPS Watch is not available
    }

    @Test
    void testGetAvailableProductsByCategorySortedByPrice_noAvailableProducts() {
        List<String> tentsProducts = catalog.getAvailableProductsByCategorySortedByPrice(Category.TENTS);
        assertNotNull(tentsProducts);
        assertTrue(tentsProducts.isEmpty()); // 2-Person Tent is not available
    }
}

