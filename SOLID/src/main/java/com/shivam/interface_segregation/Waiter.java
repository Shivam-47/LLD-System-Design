package com.shivam.interface_segregation;

import com.shivam.interface_segregation.RestaurantEmployee;

//here we can see that waiter class
//has to implement cookFood and washDishes
//even though the main job of waiter is to
//serve customers
public class Waiter implements RestaurantEmployee{

    @Override
    public void washDishes() {

    }

    @Override
    public void cookFood() {

    }

    @Override
    public void serverCustomers() {

    }

}
