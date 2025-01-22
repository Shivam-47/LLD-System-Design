package com.shivam.liskov_substitution;

//here bicycle is narrowing down
//the capabilities of parent class
public class Bicycle extends Bike{
    @Override
    public void turnOnEngine() {
        throw new AssertionError("no engine");
    }

    @Override
    public void accelerate() {

    }
}
