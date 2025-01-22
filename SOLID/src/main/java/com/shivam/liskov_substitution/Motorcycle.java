package com.shivam.liskov_substitution;


public class Motorcycle extends Bike{
    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
    }

    @Override
    public void accelerate(){
        speed = speed+10;
    }
}
