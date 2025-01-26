package com.shivam.toppings;

import com.shivam.pizza.BasePizza;

public class CheeseToppingDecorator extends BaseToppings {
    public CheeseToppingDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+10;
    }
}
