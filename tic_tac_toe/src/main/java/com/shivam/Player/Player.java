package com.shivam.Player;

import com.shivam.Piece.Piece;
import com.shivam.Piece.PieceFactory;
import com.shivam.Piece.PieceType;

public class Player {
    private int id;
    public String name;
    public Piece piece;
    private static PieceFactory pieceFactory = new PieceFactory();

    private static int idCounter=1;

    public Player(String name, Piece piece){
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.piece = piece;
    }

    public String getDetails() {
        return this.id + ":" + this.name;
    }
}
