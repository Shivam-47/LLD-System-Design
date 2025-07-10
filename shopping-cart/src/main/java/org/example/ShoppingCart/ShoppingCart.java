package org.example.ShoppingCart;

import org.example.Product.Product;
import org.example.PromoRuleEngine.*;
import org.example.PromoRuleEngine.Actions.CombinedAction;
import org.example.PromoRuleEngine.Actions.FlatDiscountAction;
import org.example.PromoRuleEngine.Actions.PercentageDiscountAction;
import org.example.PromoRuleEngine.Actions.PromotionAction;
import org.example.PromoRuleEngine.Rules.CompositeRule;
import org.example.PromoRuleEngine.Rules.MinimumPriceRule;
import org.example.PromoRuleEngine.Rules.ProductTypeRule;
import org.example.PromoRuleEngine.Rules.Rule;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private List<Product> products;
    private final PromoRuleEngine promoRuleEngine = new BaseRuleEngine();

    public ShoppingCart() {
        this.cartId = UUID.randomUUID().toString();
        this.products = new ArrayList<>();
    }

    public ShoppingCart(List<Product> products) {
        this.cartId = UUID.randomUUID().toString();
        this.products = products;
    }


    public void addToCart(Product product) {
        if (product != null) {
            Product afterPromoProduct = promoRuleEngine.getProductAfterPromo(product);

            // Uncomment the following line if you want to use
            // the FlexibleRuleEngine instead of the BaseRuleEngine
//            Product afterPromoProduct = getProductFromFlexibleEngine(product);
            this.products.add(afterPromoProduct);
        } else {
            throw new IllegalArgumentException("Product cannot be null");
        }
    }

    public Product getProductFromFlexibleEngine(Product product) {
        // Create rule engine
        FlexibleRuleEngine engine = new FlexibleRuleEngine(true);

        // Add rules using builder
        engine.addRule(RuleBuilder.createProductTypeDiscount("Electronics", 12.5, 100));
        engine.addRule(RuleBuilder.createMinimumPurchaseDiscount(100.0, 10.0, 90));

        // Or create complex rules
        Rule foodRule = new ProductTypeRule("Food", 95);
        Rule priceRule = new MinimumPriceRule(100.0, 95);
        Rule combinedRule = new CompositeRule(CompositeRule.LogicalOperator.AND, 95, foodRule, priceRule);
        PromotionAction combinedAction = new CombinedAction(
                new PercentageDiscountAction(5.0),
                new FlatDiscountAction(10.0)
        );
        engine.addRule(new PromotionRule(combinedRule, combinedAction, false));

        return engine.getProductAfterPromo(product);
    }

    public void removeFromCart(Product product) {
        //todo change this check to product id or name as product is modified by promo engine
        if (product != null && this.products.contains(product)) {
            this.products.remove(product);
        } else {
            throw new IllegalArgumentException("Product not found in cart or is null");
        }
    }

    public List<Product> getProducts() {
        return  this.products;
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (Product product : products) {
            if (product != null && product.getPrice() != null) {
                Double price = product.getPrice();
                System.out.println("Product price for " + product.getName() + ": " + price);
                totalPrice += price;
            }
        }
        return totalPrice;
    }
}
