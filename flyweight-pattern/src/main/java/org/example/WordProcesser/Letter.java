package org.example.WordProcesser;

public class Letter implements ILetter {

    private Character c;
    private String fontType;

    private int size;

    public Letter(Character c, String fontType, int size){
        this.c = c;
        this.fontType = fontType;
        this.size = size;
    }

    @Override
    public void display(int row, int column) {
        //pass the extrinsic data as parameter
    }
}
