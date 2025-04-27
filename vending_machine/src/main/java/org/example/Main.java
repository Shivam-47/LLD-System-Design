package org.example;

import org.example.VendingMachine.VendingMachine;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Vending Machine!");

        VendingMachine machine = new VendingMachine();
        try {
            machine.happyRun();
        } catch (Exception e) {
            System.out.println("Failed to process request with error:  " + e.toString());
        }
    }
}