package com.example.maven_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddProduct() {
        cart.addProduct("Laptop", 2, 50000);

        assertEquals(150000, cart.calculateTotal());
    }

    @Test
    void testRemoveProduct() {
        cart.addProduct("Mobile", 2, 10000);

        cart.removeProduct("Mobile");

        assertEquals(0, cart.calculateTotal());
    }

    @Test
    void testTotalCalculation() {
        cart.addProduct("Laptop", 1, 50000);
        cart.addProduct("Mouse", 2, 500);

        assertEquals(51000, cart.calculateTotal());
    }

    @Test
    void testDiscount() {
        cart.addProduct("Laptop", 1, 10000);

        assertEquals(9000, cart.applyDiscount(10));
    }

    @Test
    void testCoupon() {
        cart.addProduct("Mobile", 1, 20000);

        assertEquals(18000, cart.applyCoupon("SAVE10"));
    }

    @Test
    void testInvalidQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addProduct("Laptop", 0, 50000));
    }

    @Test
    void testInvalidPrice() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addProduct("Laptop", 1, -500));
    }

    @Test
    void testInvalidDiscount() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyDiscount(150));
    }

    @Test
    void testInvalidCoupon() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.applyCoupon("INVALID"));
    }

    @Test
    void testInvalidProductRemoval() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.removeProduct("Book"));
    }
}