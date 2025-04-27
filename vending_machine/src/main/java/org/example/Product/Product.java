package org.example.Product;

public class Product {
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    private static Integer serialSequenceKey = 0;

    private Integer id;
    private String name;
    private String description;
    private Integer price;

    public Product(String name, String description, Integer price){
        this.id = serialSequenceKey++;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
