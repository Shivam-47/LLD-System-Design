package com.shivam.service;

import java.util.HashMap;

public class SetupService {
    private  int numSnakes;
    private int[][] snakes;
    private int numLaders;

    private int[][] ladders;

    private final HashMap<Integer, Integer> SnakeLadderMap;

    public HashMap<Integer, Integer> getSnakeLadderMap() {
        return SnakeLadderMap;
    }

    public SetupService(int numSnakes, int[][] snakes, int numLaders, int[][] ladders) {
        this.numSnakes = numSnakes;
        this.snakes = snakes;
        this.numLaders = numLaders;
        this.ladders = ladders;
        this.SnakeLadderMap = setUpBoard();
    }

    private HashMap<Integer,Integer> setUpBoard(){
        HashMap<Integer, Integer> snakeAndLadderMap = new HashMap<Integer, Integer>();
        for(int i=0;i<numSnakes;i++){
            snakeAndLadderMap.put(snakes[i][0], snakes[i][1]);
        }

        for (int i=0;i<numLaders;i++){
            snakeAndLadderMap.put(snakes[i][0], snakes[i][1]);
        }

        return snakeAndLadderMap;
    }
}
