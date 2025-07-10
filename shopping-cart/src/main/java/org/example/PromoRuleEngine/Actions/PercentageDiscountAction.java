package org.example.PromoRuleEngine.Actions;

import org.example.Product.Product;
import org.example.Promos.PercentagePromo;

public class PercentageDiscountAction implements PromotionAction {
    private final double percentage;

    public PercentageDiscountAction(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public Product apply(Product product) {
        return new PercentagePromo(product, percentage);
    }

    @Override
    public String getDescription() {
        return percentage + "% discount";
    }

    @Override
    public boolean canCombineWith(PromotionAction other) {
        return true; // Percentage discounts can generally be combined
    }
}