package com.shivam.service;

public class OutputServiceImpl implements OutputService {
    @Override
    public void printMove(String playerName, int dieVal, int src, int dst) {
        System.out.println("Player :: "+ playerName +" rolled "+ dieVal + " and moved from "+src+" to "+dst);
    }

    @Override
    public void printWinner(String playerName) {
        System.out.println("We have a winner! Player :: "+ playerName);

    }

    @Override
    public void printLadderAtMsg(int pos) {
        System.out.println("Yay! Encountered a ladder at "+pos);
    }

    @Override
    public void printSnakeAtMsg(int pos) {
        System.out.println("Oops! Encountered a snake at "+pos);
    }

    @Override
    public void printInputMsg(){
        System.out.println("Let's start taking inputs");
    }

    @Override
    public void printInputCountValMsg(String entity) {
        System.out.println("Enter the number of " + entity);
    }

    @Override
    public void printInputPosMsg(String entity, String point) {
        System.out.println("Enter the " + entity + " " + point);
    }
}
