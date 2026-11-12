package com.example.maven_test;

import java.util.*;

class Product {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Invalid product name");

        if (quantity <= 0)
            throw new IllegalArgumentException("Invalid quantity");

        if (price <= 0)
            throw new IllegalArgumentException("Invalid price");

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class ShoppingCart {

    ArrayList<Product> cart = new ArrayList<>();

    public void addProduct(String name, int quantity, double price) {
        Product p = new Product(name, quantity, price);
        cart.add(p);
    }

    public void removeProduct(String name) {
        boolean removed = cart.removeIf(p -> p.name.equals(name));

        if (!removed)
            throw new IllegalArgumentException("Product not found");
    }

    public double calculateTotal() {
        double total = 0;

        for (Product p : cart) {
            total += p.quantity * p.price;
        }

        return total;
    }

    public double applyDiscount(double percentage) {

        if (percentage < 0 || percentage > 100)
            throw new IllegalArgumentException("Invalid discount");

        double total = calculateTotal();

        return total - (total * percentage / 100);
    }

    public double applyCoupon(String coupon) {

        if (coupon == null)
            throw new IllegalArgumentException("Invalid coupon");

        if (coupon.equals("SAVE10"))
            return applyDiscount(10);

        if (coupon.equals("SAVE20"))
            return applyDiscount(20);

        throw new IllegalArgumentException("Invalid coupon");
    }
}