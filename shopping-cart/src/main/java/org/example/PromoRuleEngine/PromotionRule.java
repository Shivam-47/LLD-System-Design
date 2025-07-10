package org.example.PromoRuleEngine;

import org.example.PromoRuleEngine.Actions.PromotionAction;
import org.example.PromoRuleEngine.Rules.Rule;

//it's a combination of a rule and an action
public class PromotionRule {
    private final Rule rule;
    private final PromotionAction action;
    private final boolean stackable;

    public PromotionRule(Rule rule, PromotionAction action, boolean stackable) {
        this.rule = rule;
        this.action = action;
        this.stackable = stackable;
    }

    public Rule getRule() { return rule; }
    public PromotionAction getAction() { return action; }
    public boolean isStackable() { return stackable; }
}