package com.shivam.factory;

public class ShapeFactory {
    public Shape getShapeObject(String shapeName){
        switch(shapeName){
            case "Triangle":
                return new Triangle();
            case "Circle":;
                return new Circle();
            case "Square":
                return new Square();
            default:
                return null;
        }
    }
}
