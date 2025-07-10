package org.example.PromoRuleEngine.Rules;
import org.example.Product.Product;

public class CompositeRule implements Rule {
    private final Rule[] rules;
    private final LogicalOperator operator;
    private final int priority;

    public enum LogicalOperator {
        AND, OR
    }

    public CompositeRule(LogicalOperator operator, int priority, Rule... rules) {
        this.operator = operator;
        this.priority = priority;
        this.rules = rules;
    }

    @Override
    public boolean matches(Product product) {
        if (operator == LogicalOperator.AND) {
            for (Rule rule : rules) {
                if (!rule.matches(product)) {
                    return false;
                }
            }
            return true;
        } else { // OR
            for (Rule rule : rules) {
                if (rule.matches(product)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rules.length; i++) {
            if (i > 0) sb.append(" ").append(operator.name()).append(" ");
            sb.append("(").append(rules[i].getDescription()).append(")");
        }
        return sb.toString();
    }
}