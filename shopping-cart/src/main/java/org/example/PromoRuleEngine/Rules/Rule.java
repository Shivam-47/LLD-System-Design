package org.example.PromoRuleEngine.Rules;

import org.example.Product.Product;

//Defines conditions for matching
public interface Rule {
    boolean matches(Product product);
    int getPriority(); // Higher priority rules apply first
    String getDescription();
}