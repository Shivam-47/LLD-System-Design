package com.shivam;

import com.shivam.Manager.Manager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Manager ticTacToeManager = new Manager(3);
        ticTacToeManager.runGame();
    }
}