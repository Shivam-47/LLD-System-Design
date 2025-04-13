package org.example.Vehicle;

public abstract class Vehicle {
    private String name;

    public Vehicle(String name){
        this.name = name;
    }

    public int getSeatCapacity(){
        return 1;
    }

    public int getTankCapacity(){
        return 1;
    }
}
