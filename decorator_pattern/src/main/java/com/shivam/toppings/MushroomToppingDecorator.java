package com.shivam.toppings;

import com.shivam.pizza.BasePizza;

public class MushroomToppingDecorator extends BaseToppings {

    public MushroomToppingDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+15;
    }
}
