package org.example.PromoRuleEngine.Actions;

import org.example.Product.Product;

//Defines the methods to apply a promotion action to a product
public interface PromotionAction {
    Product apply(Product product);
    String getDescription();
    boolean canCombineWith(PromotionAction other);
}