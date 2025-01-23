package com.shivam.withPattern;

import com.shivam.withPattern.Strategy.DriveStrategy;

public class BaseVehicle {
    public DriveStrategy driveStrategy;

    public BaseVehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
