package org.example.Vehicle;

public class Car extends Vehicle {

    public Car(String name){
        super(name);
    }

    @Override
    public int getSeatCapacity() {
        return 4;
    }

    @Override
    public int getTankCapacity() {
        return 20;
    }
}
