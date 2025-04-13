package org.example;


import org.example.Vehicle.Vehicle;
import org.example.Vehicle.Car;
import org.example.Vehicle.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle myVehicle = factory.getVehicle("Car");
        helper(myVehicle);
        helperWithPattern(myVehicle);

        Vehicle mySecondVehicle = factory.getVehicle("");
        helperWithPattern(mySecondVehicle);
    }

    private static void helper(Vehicle vehicle){
        if (vehicle != null) {
            System.out.println(vehicle.getSeatCapacity());
        }
    }

    //handles without an explicit null pointer check due to null object
    private static void helperWithPattern(Vehicle vehicle){
        System.out.println(vehicle.getSeatCapacity());
    }
}