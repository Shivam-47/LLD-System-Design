package org.example.PromoRuleEngine;

import org.example.Product.Product;
import org.example.PromoRuleEngine.Actions.PromotionAction;
import org.example.PromoRuleEngine.Rules.Rule;

import java.util.*;

public class FlexibleRuleEngine extends PromoRuleEngine {
    private final List<PromotionRule> promotionRules;
    private final boolean allowStacking;

    public FlexibleRuleEngine(boolean allowStacking) {
        this.promotionRules = new ArrayList<>();
        this.allowStacking = allowStacking;
    }

    public void addRule(PromotionRule rule) {
        promotionRules.add(rule);
        // Sort by priority (higher priority first)
        promotionRules.sort((r1, r2) -> Integer.compare(r2.getRule().getPriority(), r1.getRule().getPriority()));
    }

    public void removeRule(PromotionRule rule) {
        promotionRules.remove(rule);
    }

    public void clearRules() {
        promotionRules.clear();
    }

    @Override
    public Product getProductAfterPromo(Product product) {
        if (product == null) {
            return null;
        }

        List<PromotionAction> applicableActions = new ArrayList<>();

        // Find all matching rules
        for (PromotionRule promoRule : promotionRules) {
            if (promoRule.getRule().matches(product)) {
                applicableActions.add(promoRule.getAction());

                // If stacking is not allowed, take only the first (highest priority) match
                if (!allowStacking || !promoRule.isStackable()) {
                    break;
                }
            }
        }

        // Apply actions
        Product result = product;
        List<PromotionAction> appliedActions = new ArrayList<>();

        for (PromotionAction action : applicableActions) {
            boolean canApply = true;

            // Check if this action can be combined with already applied actions
            for (PromotionAction appliedAction : appliedActions) {
                if (!action.canCombineWith(appliedAction)) {
                    canApply = false;
                    break;
                }
            }

            if (canApply) {
                result = action.apply(result);
                appliedActions.add(action);
            }
        }

        return result;
    }

    public List<String> getApplicablePromotions(Product product) {
        List<String> descriptions = new ArrayList<>();

        for (PromotionRule promoRule : promotionRules) {
            if (promoRule.getRule().matches(product)) {
                descriptions.add(promoRule.getAction().getDescription() +
                        " (when " + promoRule.getRule().getDescription() + ")");
            }
        }

        return descriptions;
    }
}