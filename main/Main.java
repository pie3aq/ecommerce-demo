package main;

import main.catalog.Catalog;
import main.model.Category;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        System.out.println("=== All products (alphabetically sorted) ===");
        catalog.getAllProductsSortedByName().forEach(System.out::println);

        System.out.println("\n=== Available BACKPACKS (sorted by price) ===");
        catalog.getAvailableProductsByCategorySortedByPrice(Category.BACKPACKS).forEach(System.out::println);

        System.out.println("\n=== Available CAMP_KITCHEN items (sorted by price) ===");
        catalog.getAvailableProductsByCategorySortedByPrice(Category.CAMP_KITCHEN).forEach(System.out::println);
    }
}
