package org.example.Promos;
import org.example.Product.Product;

public class FlatPromo extends PromoEngine{

    private Double flatDiscount;

    public FlatPromo(Product product, Double flatDiscount) {
        super(product);
        this.flatDiscount = flatDiscount;
    }

    @Override
    public Double getPrice() {
        Double originalPrice = this.product.getPrice();
        if (originalPrice == null) {
            return null; // Handle case where original price is not set
        }
        return originalPrice - flatDiscount;
    }
}
