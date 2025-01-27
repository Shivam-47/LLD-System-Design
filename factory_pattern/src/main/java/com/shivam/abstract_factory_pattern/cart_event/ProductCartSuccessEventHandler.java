package com.shivam.abstract_factory_pattern.cart_event;

public class ProductCartSuccessEventHandler implements CartActionHandler {
    @Override
    public void HandleEvent() {
        System.out.println("Handles ProductSuccessEventHandler");
    }
}
