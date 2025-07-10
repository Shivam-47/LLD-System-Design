package org.example.Promos;

import org.example.Product.Product;

public abstract class PromoEngine extends Product {

    protected Product product;

    public PromoEngine(Product product){
        super(product);
        this.product = product;
    }
}
