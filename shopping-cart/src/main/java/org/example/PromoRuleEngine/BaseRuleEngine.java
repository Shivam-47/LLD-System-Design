package org.example.PromoRuleEngine;

import org.example.Product.ElectronicProduct;
import org.example.Product.FoodProduct;
import org.example.Product.Product;
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
