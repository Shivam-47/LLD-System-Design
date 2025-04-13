package org.example.Vehicle;

public class VehicleFactory {

    public Vehicle getVehicle(String vehicleType){
        switch (vehicleType) {
            case "Car":
                return new Car("my-car");
            default:
                return new NullVehicle();
        }
    }
}
