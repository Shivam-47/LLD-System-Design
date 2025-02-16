package com.shivam.Piece;

public class PieceFactory {

    public Piece getPieceByType(PieceType pieceType){
        switch (pieceType){
            case O -> {
                return new OPiece();
            }
            case X -> {
                return new XPiece();
            }
            default -> {
                return null;
            }
        }
    }
}
