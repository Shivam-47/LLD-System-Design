package org.example.Product;

public class ElectronicProduct extends Product {

    public ElectronicProduct(String name, Double price) {
        super(name, price, "Electronics");
    }


    @Override
    public Double getPrice() {
        return this.price;
    }
}
