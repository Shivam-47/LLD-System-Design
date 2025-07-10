package org.example;

import org.example.Product.*;
import org.example.ShoppingCart.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Shopping Cart Application!");

        ShoppingCart cart = initProductsCart();

        System.out.println("Products in the cart:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " (" + product.getpType() + ")");
        }

        Double totalPrice = cart.getTotalPrice();
        System.out.println("Total price is " + totalPrice);
    }


    private static ShoppingCart initProductsCart() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product laptop = new ElectronicProduct("Laptop", 1200.00);
        shoppingCart.addToCart(laptop);


        Product phone = new ElectronicProduct("Smartphone", 800.00);
        shoppingCart.addToCart(phone);


        Product chips = new FoodProduct("Chips", 2.50);
        shoppingCart.addToCart(chips);

        Product coke = new FoodProduct("Coke", 1.50);
        shoppingCart.addToCart(coke);

        Product importedSoda = new FoodProduct("Imported Soda", 120.00);
        shoppingCart.addToCart(importedSoda);

        return shoppingCart;
    }
}