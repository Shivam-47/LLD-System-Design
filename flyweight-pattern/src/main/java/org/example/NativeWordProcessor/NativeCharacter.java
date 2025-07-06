package org.example.NativeWordProcessor;

public class NativeCharacter {
    char character;
    String fontType;
    int size;
    int row;
    int column;

    public NativeCharacter(char c, String fontType, int size, int row, int column){
        this.character=c;
        this.size=size;
        this.fontType=fontType;
        this.row=row;
        this.column=column;
    }
}
