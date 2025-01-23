package com.shivam.withPattern;

import com.shivam.withPattern.Strategy.DriveStrategy;
import com.shivam.withPattern.Strategy.SpecialDriveStrategy;

public class SportyVehicle extends BaseVehicle {

    public SportyVehicle(){
        super(new SpecialDriveStrategy());
    }
}
