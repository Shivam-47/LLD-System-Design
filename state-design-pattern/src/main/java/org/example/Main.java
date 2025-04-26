package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to state design pattern");

        try {
            Entity entity = new Entity();
            BaseState entityState = entity.getState();
            entityState.methodA(entity);

            entityState = entity.getState();
            entityState.methodB(entity);

            entityState = entity.getState();
            entityState.methodC(entity);
        } catch (Exception e){
            System.out.println("Exception  = " + e);
        }
    }
}