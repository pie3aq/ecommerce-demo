package main;

import main.catalog.Catalog;
import main.model.Product;
import main.model.Category;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        catalog.addProduct(new Product("Waterproof Jacket", 499.99, Category.CLOTHING, true));
        catalog.addProduct(new Product("Trekking Boots", 629.00, Category.FOOTWEAR, true));
        catalog.addProduct(new Product("Backpack 20L", 199.00, Category.BACKPACKS, true));
        catalog.addProduct(new Product("Backpack 40L", 349.00, Category.BACKPACKS, true));
        catalog.addProduct(new Product("Backpack 60L", 499.00, Category.BACKPACKS, true));
        catalog.addProduct(new Product("2-Person Tent", 899.99, Category.TENTS, false));
        catalog.addProduct(new Product("LED Headlamp", 149.99, Category.LIGHTING, true));
        catalog.addProduct(new Product("Gas Stove", 99.90, Category.CAMP_KITCHEN, true));
        catalog.addProduct(new Product("Titanium Pot", 149.50, Category.CAMP_KITCHEN, true));
        catalog.addProduct(new Product("Camping Cutlery Set", 39.90, Category.CAMP_KITCHEN, true));
        catalog.addProduct(new Product("Windshield for Stove", 59.00, Category.CAMP_KITCHEN, true));
        catalog.addProduct(new Product("Mini Stove - discontinued", 79.99, Category.CAMP_KITCHEN, false));
        catalog.addProduct(new Product("Climbing Quickdraw Set", 299.99, Category.CLIMBING_GEAR, true));
        catalog.addProduct(new Product("GPS Watch", 1199.00, Category.ELECTRONICS, false));

        System.out.println("=== All products (alphabetically sorted) ===");
        catalog.getAllProductsSortedByName().forEach(System.out::println);

        System.out.println("\n=== Available BACKPACKS (sorted by price) ===");
        catalog.getAvailableProductsByCategorySortedByPrice(Category.BACKPACKS).forEach(System.out::println);

        System.out.println("\n=== Available CAMP_KITCHEN items (sorted by price) ===");
        catalog.getAvailableProductsByCategorySortedByPrice(Category.CAMP_KITCHEN).forEach(System.out::println);
    }
}
