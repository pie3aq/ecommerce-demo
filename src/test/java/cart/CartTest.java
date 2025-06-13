package main.cart;

import main.model.Product;
import main.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    private Cart cart;
    private Product product1;
    private Product product2;
    private Product unavailableProduct;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        product1 = new Product("Product 1", 10.0, Category.CLOTHING, true);
        product2 = new Product("Product 2", 20.0, Category.ELECTRONICS, true);
        unavailableProduct = new Product("Unavailable Product", 5.0, Category.CLOTHING, false);
    }

    @Test
    void testAddProduct() {
        cart.addProduct(product1);
        assertEquals(10.0, cart.getTotalPrice());
        cart.addProduct(product1);
        assertEquals(20.0, cart.getTotalPrice());
    }

    @Test
    void testAddUnavailableProduct() {
        cart.addProduct(unavailableProduct);
        assertEquals(0.0, cart.getTotalPrice());
    }

    @Test
    void testRemoveProduct() {
        cart.addProduct(product1);
        cart.addProduct(product1);
        assertEquals(20.0, cart.getTotalPrice());

        cart.removeProduct(product1);
        assertEquals(10.0, cart.getTotalPrice());

        cart.removeProduct(product1);
        assertEquals(0.0, cart.getTotalPrice());

        // Removing a product not in cart should not cause issues
        cart.removeProduct(product2);
        assertEquals(0.0, cart.getTotalPrice());
    }

    @Test
    void testGetTotalPriceWithoutPromotion() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(30.0, cart.getTotalPrice());
    }

    @Test
    void testSetPromotionByCode() {
        cart.addProduct(product1);
        cart.addProduct(product1);
        cart.addProduct(product1);
        // Test a valid promotion code (assuming '3FOR2' is a valid code in PromotionFactory)
        cart.setPromotionByCode("3ZA2");
        // With 3FOR2, price for 3 items of 10.0 should be 20.0
        assertEquals(20.0, cart.getTotalPrice());

        // Test an invalid promotion code
        cart.setPromotionByCode("INVALID");
        assertEquals(30.0, cart.getTotalPrice()); // Should revert to original price
    }

    @Test
    void testPrintContents() {
        // This method prints to console, so direct assertion is hard.
        // We can redirect System.out for testing, but for now, we'll just call it
        // and ensure no exceptions are thrown.
        cart.printContents(); // Empty cart
        cart.addProduct(product1);
        cart.printContents(); // Cart with product1
    }
}

