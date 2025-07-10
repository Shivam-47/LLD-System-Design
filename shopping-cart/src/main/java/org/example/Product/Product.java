package org.example.Product;

public abstract class Product {

    protected String name;
    protected Double price;
    protected String pType;

    public Product(String name, Double price, String pType) {
        this.name = name;
        this.price = price;
        this.pType = pType;
    }

    public Product(Product product){
        this.name = product.getName();
        this.price = product.getPrice();
        this.pType = product.pType;
    }

    public String getName() {
        return name;
    }

    public abstract Double getPrice();

    public String getpType() {
        return pType;
    }
}
