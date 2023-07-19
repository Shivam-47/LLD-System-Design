package com.shivam.service;

import java.util.Scanner;

public class InputService {
    private int numSnake;
    private int numLadders;
    private int[][] snakes;
    private int[][] ladders;
    private int numPlayers;

    private OutputServiceImpl outputService;

    public int getNumSnake() {
        return numSnake;
    }

    public void setNumSnake(int numSnake) {
        this.numSnake = numSnake;
    }

    public int getNumLadders() {
        return numLadders;
    }

    public void setNumLadders(int numLadders) {
        this.numLadders = numLadders;
    }

    public int[][] getSnakes() {
        return snakes;
    }

    public void setSnakes(int[][] snakes) {
        this.snakes = snakes;
    }

    public int[][] getLadders() {
        return ladders;
    }

    public void setLadders(int[][] ladders) {
        this.ladders = ladders;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    private String[] playerNames;

    public InputService(){
        outputService = new OutputServiceImpl();
        outputService.printInputMsg();
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        outputService.printInputCountValMsg("snake");
        setNumSnake(sc.nextInt());

        setSnakes(scanEntity(sc, "snake", numSnake));
        outputService.printInputCountValMsg("ladder");
        setNumLadders(sc.nextInt());

        setLadders(scanEntity(sc, "ladder",numLadders));
        outputService.printInputCountValMsg("players");
        setNumPlayers(sc.nextInt());

        setPlayerNames(scanPlayerNames(sc));
    }

    private int[][] scanEntity(Scanner sc, String entityType, int nums){
        int entityList[][] = new int[nums][2];
        for(int i=0;i<nums;i++){
            int [] temp = new int[2];
            outputService.printInputPosMsg(entityType, "source");
            temp[0] = sc.nextInt();
            outputService.printInputPosMsg(entityType, "destination");
            temp[1] = sc.nextInt();
            entityList[i] = temp;
        }
        return entityList;
    }

    private String[] scanPlayerNames(Scanner sc){
        String[] playerName = new String[numPlayers];

        for(int i=0;i<numPlayers;i++){
            System.out.println("Enter player name :: ");
            playerName[i] = sc.next();
        }
        return playerName;
    }

}
