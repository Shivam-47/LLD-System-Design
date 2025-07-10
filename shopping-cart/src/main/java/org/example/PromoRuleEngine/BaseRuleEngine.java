package org.example.PromoRuleEngine;

import org.example.Product.ElectronicProduct;
import org.example.Product.FoodProduct;
import org.example.Product.Product;
import org.example.PromoRuleEngine.Actions.CombinedAction;
import org.example.PromoRuleEngine.Actions.FlatDiscountAction;
import org.example.PromoRuleEngine.Actions.PercentageDiscountAction;
import org.example.PromoRuleEngine.Actions.PromotionAction;
import org.example.PromoRuleEngine.Rules.CompositeRule;
import org.example.PromoRuleEngine.Rules.MinimumPriceRule;
import org.example.PromoRuleEngine.Rules.ProductTypeRule;
import org.example.PromoRuleEngine.Rules.Rule;
import org.example.Promos.FlatPromo;
import org.example.Promos.PercentagePromo;

public class BaseRuleEngine extends PromoRuleEngine{

    public BaseRuleEngine() {
    }

    @Override
    public Product getProductAfterPromo(Product product) {
        if(product.getpType() == "Electronics") {
            return new PercentagePromo(product, 12.5);
        } else if(product.getpType() == "Food") {
            if (product.getPrice() >= 100.0) {
                return new FlatPromo(new PercentagePromo(product, 5.0), 10.0);
            }
            return new PercentagePromo(product, 5.0);
        } else {
            return product;
        }
    }
}
