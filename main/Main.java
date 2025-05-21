package main;

import main.catalog.Catalog;
import main.cart.Cart;
import main.model.Category;
import main.model.Product;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        System.out.println("=== All products (alphabetically sorted) ===");
        catalog.getAllProductsSortedByName().forEach(System.out::println);

        System.out.println("\n=== Available BACKPACKS (sorted by price) ===");
        catalog.getAvailableProductsByCategorySortedByPrice(Category.BACKPACKS).forEach(System.out::println);

        System.out.println("\n=== Available CAMP_KITCHEN items (sorted by price) ===");
        catalog.getAvailableProductsByCategorySortedByPrice(Category.CAMP_KITCHEN).forEach(System.out::println);

        Cart cart = new Cart();

        Product backpack20L = new Product("Backpack 20L", 199.00, Category.BACKPACKS, true);
        Product stove = new Product("Gas Stove", 99.90, Category.CAMP_KITCHEN, true);
        Product tent = new Product("2-Person Tent", 899.99, Category.TENTS, false);
        cart.addProduct(backpack20L);
        cart.addProduct(backpack20L);
        cart.addProduct(stove);
        cart.addProduct(tent);

        cart.printContents();

        System.out.printf("No promotion: %.2f PLN%n", cart.getTotalPrice());

        cart.setPromotionByCode("PROMO10");
        System.out.printf("With PROMO10: %.2f PLN%n", cart.getTotalPrice());

        cart.setPromotionByCode("3ZA2");
        System.out.printf("With 3ZA2: %.2f PLN%n", cart.getTotalPrice());

        cart.setPromotionByCode("2POL");
        System.out.printf("With 2POL: %.2f PLN%n", cart.getTotalPrice());

        cart.setPromotionByCode("INVALID");
        System.out.printf("With INVALID code: %.2f PLN%n", cart.getTotalPrice());

        cart.removeProduct(backpack20L);
        cart.printContents();
        System.out.printf("Total price: %.2f PLN%n", cart.getTotalPrice());
    }
}
