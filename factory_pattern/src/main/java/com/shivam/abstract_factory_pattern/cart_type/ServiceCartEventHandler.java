package com.shivam.abstract_factory_pattern.cart_type;

import com.shivam.abstract_factory_pattern.cart_event.CartActionHandler;
import com.shivam.abstract_factory_pattern.cart_event.ServiceCartFailedEventHandler;
import com.shivam.abstract_factory_pattern.cart_event.ServiceCartSuccessEventHandler;

public class ServiceCartEventHandler implements CartTypeEventHandler {
    @Override
    public CartActionHandler getActionHandler(String action){
        switch (action) {
            case "success":
                return new ServiceCartSuccessEventHandler();
            case "failed":
                return new ServiceCartFailedEventHandler();
            default:
                return null;
        }
    }
}
