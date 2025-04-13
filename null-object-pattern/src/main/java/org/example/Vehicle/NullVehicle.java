package org.example.Vehicle;

/*
    Default Null object class returning default value
*/
public class NullVehicle extends Vehicle {
    public NullVehicle(){
        super("null");
    }

    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatCapacity() {
        return 0;
    }
}
