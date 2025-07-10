package org.example.PromoRuleEngine.Rules;

import org.example.Product.Product;

public class MinimumPriceRule implements Rule {
    private final double minimumPrice;
    private final int priority;

    public MinimumPriceRule(double minimumPrice, int priority) {
        this.minimumPrice = minimumPrice;
        this.priority = priority;
    }

    @Override
    public boolean matches(Product product) {
        return product.getPrice() != null && product.getPrice() >= minimumPrice;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getDescription() {
        return "Minimum price is $" + minimumPrice;
    }
}