package org.example.PromoRuleEngine.Actions;

import org.example.Product.Product;

public class CombinedAction implements PromotionAction {
    private final PromotionAction[] actions;

    public CombinedAction(PromotionAction... actions) {
        this.actions = actions;
    }

    @Override
    public Product apply(Product product) {
        Product result = product;
        for (PromotionAction action : actions) {
            result = action.apply(result);
        }
        return result;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < actions.length; i++) {
            if (i > 0) sb.append(" + ");
            sb.append(actions[i].getDescription());
        }
        return sb.toString();
    }

    @Override
    public boolean canCombineWith(PromotionAction other) {
        return false; // Combined actions typically don't stack with others
    }
}