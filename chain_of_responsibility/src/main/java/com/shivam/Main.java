package com.shivam;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! Welcome to Chain of Responsibility Pattern");

        BaseHandler customBaseHandler = new FirstHandler(new SecondHandler(new ThirdHandler(null)));
        customBaseHandler.callMethod(1);
        customBaseHandler.callMethod(2);
        customBaseHandler.callMethod(3);
        customBaseHandler.callMethod(4);
    }
}