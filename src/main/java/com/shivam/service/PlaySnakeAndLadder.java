package com.shivam.service;

import java.util.HashMap;
import java.util.Random;

public class PlaySnakeAndLadder implements PlayService {
    private SetupService setupService;
    private PlayerService playerService;
    private OutputServiceImpl outputService;
    private HashMap<Integer, Integer> snakeAndLadderMap;
    private int [] playersPosition;
    @Override
    public void play(int numSnakes, int[][] snakes, int numLaders, int[][] ladders, int numPlayers, String [] playerNames) {
        setupService = new SetupService(numSnakes, snakes, numLaders, ladders);
        outputService = new OutputServiceImpl();
        playerService = new PlayerService(numPlayers, playerNames);
        this.snakeAndLadderMap =  setupService.getSnakeLadderMap();
        playGame(numPlayers);
    }

    private void playGame(int numPlayers){
        playersPosition = new int[numPlayers];
        int currChance=0;

        while(true){
            int dieNum = rollDie();
            int newPos = move(dieNum, playersPosition[currChance]);
            if(newPos==-1){
                //in case of crossing the bound of last cell retry next time
                currChance = (currChance+1)%numPlayers;
                continue;
            }
            outputService.printMove(playerService.getPlayerName(currChance), dieNum, playersPosition[currChance], newPos);
            playersPosition[currChance] = newPos;
            if(newPos == 100){
                outputService.printWinner(playerService.getPlayerName(currChance));
                break;
            }
            currChance = (currChance+1)%numPlayers;
        }

    }

    private int move(int delta, int currPos){
        if(currPos + delta > 100)
                return -1;

        int newPos = currPos+delta;

        if(snakeAndLadderMap.containsKey(newPos)) {
            int val = snakeAndLadderMap.get(newPos);
            if(val>newPos) {
                outputService.printLadderAtMsg(newPos);
            } else {
                outputService.printSnakeAtMsg(newPos);
            }
            newPos = val;
        }

        return newPos;
    }

    private int rollDie(){
        Random random = new Random();
        return random.ints(1, 7)
                .findFirst()
                .getAsInt();
    }
}
