package org.example.PromoRuleEngine.Rules;

import org.example.Product.Product;

public class ProductTypeRule implements Rule {
    private final String productType;
    private final int priority;

    public ProductTypeRule(String productType, int priority) {
        this.productType = productType;
        this.priority = priority;
    }

    @Override
    public boolean matches(Product product) {
        return product.getpType() != null && product.getpType().equals(productType);
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getDescription() {
        return "Product type is " + productType;
    }
}