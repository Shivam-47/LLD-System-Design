package com.shivam;

import com.shivam.factory.ShapeFactory;
import com.shivam.factory.Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShapeObject("Circle");
        if(circle != null)
            circle.drawShape();

        Shape triangle = shapeFactory.getShapeObject("Triangle");
        if(triangle != null)
            triangle.drawShape();
    }
}