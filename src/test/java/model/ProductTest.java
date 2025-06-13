package main.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testProductCreation() {
        Product product = new Product("Test Product", 10.0, Category.CLOTHING, true);
        assertNotNull(product);
        assertEquals("Test Product", product.getName());
        assertEquals(10.0, product.getPrice());
        assertEquals(Category.CLOTHING, product.getCategory());
        assertTrue(product.isAvailable());
    }

    @Test
    void testToString() {
        Product product = new Product("Test Product", 10.0, Category.CLOTHING, true);
        assertEquals("Test Product - 10.0 PLN", product.toString());
    }

    @Test
    void testEquals() {
        Product product1 = new Product("Test Product", 10.0, Category.CLOTHING, true);
        Product product2 = new Product("Test Product", 10.0, Category.CLOTHING, false);
        Product product3 = new Product("Another Product", 10.0, Category.CLOTHING, true);

        assertTrue(product1.equals(product2)); // Availability should not affect equality
        assertFalse(product1.equals(product3));
        assertFalse(product1.equals(null));
        assertFalse(product1.equals("String"));
    }

    @Test
    void testHashCode() {
        Product product1 = new Product("Test Product", 10.0, Category.CLOTHING, true);
        Product product2 = new Product("Test Product", 10.0, Category.CLOTHING, false);

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}

