package org.example.PromoRuleEngine;

import org.example.PromoRuleEngine.Actions.*;
import org.example.PromoRuleEngine.Actions.CombinedAction;
import org.example.PromoRuleEngine.Rules.*;

public class RuleBuilder {

    public static PromotionRule createProductTypeDiscount(String productType, double percentage, int priority) {
        Rule rule = new ProductTypeRule(productType, priority);
        PromotionAction action = new PercentageDiscountAction(percentage);
        return new PromotionRule(rule, action, true);
    }

    public static PromotionRule createMinimumPurchaseDiscount(double minPrice, double flatDiscount, int priority) {
        Rule rule = new MinimumPriceRule(minPrice, priority);
        PromotionAction action = new FlatDiscountAction(flatDiscount);
        return new PromotionRule(rule, action, true);
    }

    public static PromotionRule createComboDiscount(String productType, double minPrice,
                                                    double percentage, double flatDiscount, int priority) {
        Rule typeRule = new ProductTypeRule(productType, priority);
        Rule priceRule = new MinimumPriceRule(minPrice, priority);
        Rule compositeRule = new CompositeRule(CompositeRule.LogicalOperator.AND, priority, typeRule, priceRule);

        // Create combined action (percentage first, then flat)
        PromotionAction percentageAction = new PercentageDiscountAction(percentage);
        PromotionAction flatAction = new FlatDiscountAction(flatDiscount);
        PromotionAction combinedAction = new CombinedAction(percentageAction, flatAction);

        return new PromotionRule(compositeRule, combinedAction, false);
    }
}