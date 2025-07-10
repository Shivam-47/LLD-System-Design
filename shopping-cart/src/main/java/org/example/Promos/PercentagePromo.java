package org.example.Promos;

import org.example.Product.Product;

public class PercentagePromo extends PromoEngine {

    private Double discountPercentage;

    public PercentagePromo(Product product, Double discountPercentage) {
        super(product);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public Double getPrice() {
        Double originalPrice = this.product.getPrice();
        if (originalPrice == null) {
            return null; // Handle case where original price is not set
        }
        return originalPrice * (1 - discountPercentage / 100);
    }
}
