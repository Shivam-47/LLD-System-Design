package com.shivam.abstract_factory_pattern.cart_type;

import com.shivam.abstract_factory_pattern.cart_event.CartActionHandler;
import com.shivam.abstract_factory_pattern.cart_event.ProductCartFailedEventHandler;
import com.shivam.abstract_factory_pattern.cart_event.ProductCartSuccessEventHandler;

public class ProductCartEventHandler implements CartTypeEventHandler {
    @Override
    public CartActionHandler getActionHandler(String eventType){
        switch (eventType){
            case "success":
                return new ProductCartSuccessEventHandler();
            case "failed":
                return new ProductCartFailedEventHandler();
            default:
                return null;
        }
    }
}
