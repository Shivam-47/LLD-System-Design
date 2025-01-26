package com.shivam;

import com.shivam.pizza.BasePizza;
import com.shivam.pizza.Farmhouse;
import com.shivam.pizza.Margherita;
import com.shivam.pizza.PeppyPaneer;
import com.shivam.toppings.CheeseToppingDecorator;
import com.shivam.toppings.MushroomToppingDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Decorator pattern");

        //100+15
        BasePizza margheritaWithMushroom = new MushroomToppingDecorator(new Margherita());
        System.out.println("margheritaWithMushroom cost: " + margheritaWithMushroom.cost());

        //180+15+10
        BasePizza farmHouseWithMushroomAndCheese = new CheeseToppingDecorator(new MushroomToppingDecorator(new Farmhouse()));
        farmHouseWithMushroomAndCheese.cost();
        System.out.println("farmHouseWithMushroomAndCheese cost: " + farmHouseWithMushroomAndCheese.cost());

        //200+10
        BasePizza peppyPaneerWithCheese = new CheeseToppingDecorator(new PeppyPaneer());
        System.out.println("peppyPaneerWithCheese cost: " + peppyPaneerWithCheese.cost());
    }
}