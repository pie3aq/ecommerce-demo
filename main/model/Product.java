package main.model;

public class Product {
    private String name;
    private double price;
    private Category category;
    private boolean available;

    public Product(String name, double price, Category category, boolean available) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return name + " - " + price + " PLN";
    }
}