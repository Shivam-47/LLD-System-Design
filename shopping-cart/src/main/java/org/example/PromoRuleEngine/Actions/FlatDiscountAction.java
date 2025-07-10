package org.example.PromoRuleEngine.Actions;

import org.example.Product.Product;
import org.example.Promos.FlatPromo;

public class FlatDiscountAction implements PromotionAction {
    private final double amount;

    public FlatDiscountAction(double amount) {
        this.amount = amount;
    }

    @Override
    public Product apply(Product product) {
        return new FlatPromo(product, amount);
    }

    @Override
    public String getDescription() {
        return "$" + amount + " off";
    }

    @Override
    public boolean canCombineWith(PromotionAction other) {
        return !(other instanceof FlatDiscountAction); // Don't stack flat discounts
    }
}