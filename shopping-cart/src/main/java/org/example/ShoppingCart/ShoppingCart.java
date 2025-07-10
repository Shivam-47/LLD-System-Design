package org.example.ShoppingCart;

import org.example.Product.Product;
import org.example.PromoRuleEngine.BaseRuleEngine;
import org.example.PromoRuleEngine.PromoRuleEngine;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private List<Product> products;
    private final PromoRuleEngine promoRuleEngine = new BaseRuleEngine();

    public ShoppingCart() {
        this.cartId = UUID.randomUUID().toString();
        this.products = new ArrayList<>();
    }

    public ShoppingCart(List<Product> products) {
        this.cartId = UUID.randomUUID().toString();
        this.products = products;
    }


    public void addToCart(Product product) {
        if (product != null) {
            Product afterPromoProduct = promoRuleEngine.getProductAfterPromo(product);
            this.products.add(afterPromoProduct);
        } else {
            throw new IllegalArgumentException("Product cannot be null");
        }
    }

    public void removeFromCart(Product product) {
        //todo change this check to product id or name as product is modified by promo engine
        if (product != null && this.products.contains(product)) {
            this.products.remove(product);
        } else {
            throw new IllegalArgumentException("Product not found in cart or is null");
        }
    }

    public List<Product> getProducts() {
        return  this.products;
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (Product product : products) {
            if (product != null && product.getPrice() != null) {
                Double price = product.getPrice();
                System.out.println("Product price for " + product.getName() + ": " + price);
                totalPrice += price;
            }
        }
        return totalPrice;
    }
}
