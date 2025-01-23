package com.shivam.withPattern;

import com.shivam.withPattern.Strategy.DriveStrategy;
import com.shivam.withPattern.Strategy.SpecialDriveStrategy;

public class OffroadVehicle extends BaseVehicle {
    public OffroadVehicle(){
        super(new SpecialDriveStrategy());
    }
}
