package com.shivam.abstract_factory_pattern.cart_type;

public class CartTypeEventHandlerFactory {
    public CartTypeEventHandler getCartTypeEventHandlerFactory(String cartType){
        switch (cartType){
            case "product":
                return new ProductCartEventHandler();
            case "service":
                return new ServiceCartEventHandler();
            default:
                return null;
        }
    }
}
