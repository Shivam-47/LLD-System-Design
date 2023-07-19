package com.shivam.service;

public interface OutputService {
    void printMove(String playerName, int dieVal, int src, int dst);
    void printWinner(String playerName);
    void printLadderAtMsg(int pos);
    void printSnakeAtMsg(int pos);
    void printInputMsg();

    void printInputCountValMsg(String entity);
    void printInputPosMsg(String entity, String point);

}
