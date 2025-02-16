package com.shivam.Piece;

public class Piece {

    private PieceType pieceType;

    Piece(PieceType pieceType){
        this.pieceType=pieceType;
    }

    public String toString(){
        return this.pieceType.toString();
    }
}
