package com.shivam.abstract_factory_pattern.cart_type;

import com.shivam.abstract_factory_pattern.cart_event.CartActionHandler;

public interface CartTypeEventHandler {
    CartActionHandler getActionHandler(String eventType);
}
