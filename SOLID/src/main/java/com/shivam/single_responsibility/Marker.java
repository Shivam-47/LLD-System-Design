package com.shivam.single_responsibility;

public class Marker {
    private String name;
    private String color;
    private int price;

    public Marker(String name, String color, int price){
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
