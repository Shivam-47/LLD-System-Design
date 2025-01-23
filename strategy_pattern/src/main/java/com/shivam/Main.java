package com.shivam;

import com.shivam.withPattern.BaseVehicle;
import com.shivam.withPattern.SportyVehicle;
import com.shivam.withPattern.Strategy.NormalDriveStrategy;
import com.shivam.withoutPattern.OffroadVehicle;
import com.shivam.withoutPattern.PassengerVehicle;

public class Main {
    public static void main(String[] args) {

        System.out.println("Without pattern");

        PassengerVehicle pv = new PassengerVehicle();
        pv.drive();

        OffroadVehicle ov = new OffroadVehicle();
        ov.drive();

        System.out.println("With pattern");
        NormalDriveStrategy nds = new NormalDriveStrategy();
        BaseVehicle bv = new BaseVehicle(nds);
        bv.drive();

        BaseVehicle npv = new com.shivam.withPattern.PassengerVehicle();
        npv.drive();

        BaseVehicle nsv = new SportyVehicle();
        nsv.drive();
    }
}