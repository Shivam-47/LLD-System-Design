package com.shivam.Board;

import com.shivam.Piece.Piece;

import java.util.Objects;

public class Board {
    private Piece[][]board;
    int size;

    public Board(int size) {
        this.size=size;
        this.board= new Piece[size][size];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null)
                    System.out.printf(" | ");
                else
                    System.out.printf("%s|", board[i][j].toString());
            }

            System.out.println();
        }
    }

    public boolean setPiece(int x, int y, Piece piece){
        try {
            if(board[x][y] != null){
                throw new Exception("position is already taken");
            }

            this.board[x][y] = piece;
            return true;
        } catch (Exception e) {
            System.out.printf("Exception: %s: invalid coordinates passed", e.getMessage());
            return false;
        }
    }

    //todo implement the O(1) solution instead of O(N)
    public boolean isSolved(){
        //check rows
        for(int i=0;i<size;i++){
            int matchCount=0;
            for(int j=1;j<size;j++){
                if(board[i][j] != null && board[i][j-1] != null && Objects.equals(board[i][j].toString(), board[i][j - 1].toString())) {
                    matchCount++;
                    continue;
                }
                break;
            }

            if(matchCount==size-1)
                return true;
        }

        //check columns
        for(int j=0;j<size;j++){
            int matchCount=0;
            for(int i=1;i<size;i++){
                if(board[i][j] != null && board[i-1][j] != null && Objects.equals(board[i][j].toString(), board[i - 1][j].toString())) {
                    matchCount++;
                    continue;
                }
                break;
            }

            if(matchCount == size-1)
                return true;
        }

        //check diagonal
        int matchCount = 0;
        for(int i=1;i<size;i++){
            if(board[i][i] != null && board[i-1][i-1] != null && Objects.equals(board[i][i].toString(), board[i - 1][i - 1].toString())){
                matchCount++;
                continue;
            }
            break;
        }

        if(matchCount==size-1)
            return true;

        //check upper diagonal
        matchCount = 0;
        for(int i=size-2;i>=0;i--){
            if(board[i][size-1-i] != null && board[i+1][size-1-(i+1)] != null && Objects.equals(board[i][size - 1 - i].toString(), board[i + 1][size - 1 - (i + 1)].toString())){
                matchCount++;
                continue;
            }
            break;
        }

        return (matchCount==size-1);
    }
}
