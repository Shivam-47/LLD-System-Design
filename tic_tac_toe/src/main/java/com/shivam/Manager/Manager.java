package com.shivam.Manager;

import com.shivam.Board.Board;
import com.shivam.Piece.PieceFactory;
import com.shivam.Piece.PieceType;
import com.shivam.Player.Player;

import java.util.*;

public class Manager {
    private Board board;
    public List<Player> playerList;

    private static PieceFactory pieceFactory = new PieceFactory();

    int boardSize;

    public Manager(int boardSize){
        this.boardSize = boardSize;
        this.board = new Board(boardSize);
        this.playerList = new ArrayList<Player>();
    }

    public void runGame() {
        System.out.println("Welcome to TIC TAC TOE!");

        System.out.println("Enter player 1 name");
        Scanner inputScanner = new Scanner(System.in);
        String playerName = inputScanner.nextLine();
        this.playerList.add(new Player(playerName,  this.pieceFactory.getPieceByType(PieceType.X)));

        System.out.println("Enter player 2 name");
        playerName = inputScanner.nextLine();
        this.playerList.add(new Player(playerName, this.pieceFactory.getPieceByType(PieceType.O)));

        int index=0;
        int turnsLeft = boardSize*boardSize;
        int numPlayers = playerList.size();


        while(!this.board.isSolved() && turnsLeft > 0){

            System.out.println("Current Grid");
            this.board.printBoard();

            Player currentPlayer = this.playerList.get(index);
            System.out.printf("Player %d 's turn: Please select an empty cell\n", index+1);
            String inputStr = inputScanner.nextLine();
            String[] values = inputStr.split(",");

            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean isPiecePlaced = this.board.setPiece(row, col, currentPlayer.piece);
            if (!isPiecePlaced){
                System.out.println("incorrect position please try again");
                continue;
            }

            if(this.board.isSolved()){
                System.out.printf("Congratulations to Player: %s for winning the game\n", currentPlayer.getDetails());
                break;
            }

            turnsLeft--;
            if(turnsLeft==0){
                System.out.println("Uh Oh! Game ended in stalemate!");
                break;
            }

            index = (index+1)%numPlayers;
        }

        this.board.printBoard();
        System.out.println("Closing the game!");
    }
}
