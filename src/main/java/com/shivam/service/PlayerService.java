package com.shivam.service;

import java.util.HashMap;

public class PlayerService {


    private HashMap<Integer, String> playerMap;
    private int numPlayers;
    private String []playerNames;

    PlayerService(int numPlayers,String []playerNames){
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;
        this.playerMap = populatePlayerMap();
    }

    private HashMap<Integer,String> populatePlayerMap(){
        HashMap<Integer, String> playerMap = new HashMap<Integer, String>();
        for(int i=0;i<numPlayers;i++){
            playerMap.put(i,playerNames[i]);
        }

        return playerMap;
    }

    public String getPlayerName(int id) {
        return playerMap.get(id);
    }
}
