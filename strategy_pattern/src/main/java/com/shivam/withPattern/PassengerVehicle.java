package com.shivam.withPattern;

import com.shivam.withPattern.Strategy.DriveStrategy;
import com.shivam.withPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends BaseVehicle{
    public PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
