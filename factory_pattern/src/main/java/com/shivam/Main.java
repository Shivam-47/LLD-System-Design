package com.shivam;

import com.shivam.abstract_factory_pattern.cart_event.CartActionHandler;
import com.shivam.abstract_factory_pattern.cart_type.CartTypeEventHandler;
import com.shivam.abstract_factory_pattern.cart_type.CartTypeEventHandlerFactory;
import com.shivam.factory.ShapeFactory;
import com.shivam.factory.Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello factory!");

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShapeObject("Circle");
        if(circle != null)
            circle.drawShape();

        Shape triangle = shapeFactory.getShapeObject("Triangle");
        if(triangle != null)
            triangle.drawShape();

        System.out.println("Hello Abstract Factory");

        CartTypeEventHandlerFactory cartTypeEventHandlerFactory = new CartTypeEventHandlerFactory();
        CartTypeEventHandler productCartEventHandler = cartTypeEventHandlerFactory.getCartTypeEventHandlerFactory("product");

        CartActionHandler successProductCartHandler = productCartEventHandler.getActionHandler("success");
        successProductCartHandler.HandleEvent();

        CartTypeEventHandler serviceCartEventHandler = cartTypeEventHandlerFactory.getCartTypeEventHandlerFactory("service");
        CartActionHandler failedServiceCartHandler = serviceCartEventHandler.getActionHandler("failed");
        failedServiceCartHandler.HandleEvent();
    }
}