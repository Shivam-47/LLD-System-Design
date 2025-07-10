package org.example.PromoRuleEngine;

public class EnhancedBaseRuleEngine extends FlexibleRuleEngine {

    public EnhancedBaseRuleEngine() {
        super(true); // Allow stacking
        initializeRules();
    }

    private void initializeRules() {
        // Electronics get 12.5% discount
        addRule(RuleBuilder.createProductTypeDiscount("Electronics", 12.5, 100));

        // Food gets 5% discount
        addRule(RuleBuilder.createProductTypeDiscount("Food", 5.0, 90));

        // Food items over $100 get additional $10 flat discount
        addRule(RuleBuilder.createComboDiscount("Food", 100.0, 5.0, 10.0, 95));
    }
}