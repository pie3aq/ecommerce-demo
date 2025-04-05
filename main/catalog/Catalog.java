package main.catalog;

import main.model.Product;
import main.model.Category;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private List<Product> products;

    public Catalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<String> getAllProductsSortedByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .map(Product::toString)
                .collect(Collectors.toList());
    }

    public List<String> getAvailableProductsByCategorySortedByPrice(Category category) {
        return products.stream()
                .filter(p -> p.getCategory() == category && p.isAvailable())
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .map(Product::toString)
                .collect(Collectors.toList());
    }
}
