package org.example.Product;

public class FoodProduct extends Product{

    public FoodProduct(String name, Double price) {
        super(name, price, "Food");
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
