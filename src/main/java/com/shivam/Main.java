package com.shivam;

import com.shivam.service.InputService;
import com.shivam.service.PlaySnakeAndLadder;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world! Welcome to snake and ladder");
        PlaySnakeAndLadder playSnakeAndLadder = new PlaySnakeAndLadder();
        InputService inputService = new InputService();
        inputService.input();
        playSnakeAndLadder.play(inputService.getNumSnake(), inputService.getSnakes(), inputService.getNumLadders(),
                inputService.getLadders(), inputService.getNumPlayers(), inputService.getPlayerNames());

        /*
        Uncomment to run hardcoded input
        int numSnakes = 9;
        int numLadders = 8;
        int snakes [][] = {{62,5}, {33,6}, {49,9}, {88,16}, {41,20}, {56,53}, {98,64},{93,73},{95,75}};
        int ladders [][] = {{2,37},{27,46},{10,32},{51,68},{61,79},{65,84},{71,91},{81,100}};
        int numPlayers = 3;
        String [] playerNames = {"Gaurav", "Sagar", "Snowden"};
        playSnakeAndLadder.play(numSnakes, snakes, numLadders, ladders, numPlayers, playerNames);
        */
    }
}