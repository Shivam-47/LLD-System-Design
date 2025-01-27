package com.shivam.abstract_factory_pattern.cart_event;

public class ProductSuccessEventHandler implements CartActionHandler {
    @Override
    public void HandleEvent() {
        System.out.println("Handles ProductSuccessEventHandler");
    }
}
