package org.example;

import org.example.Interfaces.RoomElement;
import org.example.Interfaces.RoomOperationVisitor;
import org.example.RoomElement.*;
import org.example.RoomOperationVisitor.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome to Visitor Pattern!\n");

        // current code has cyclic dependency between RoomElement and RoomOperationVisitor
        // to solve this, we can
        // move all the files to a common package
        // create both interfaces in a separate package as Generics and use them
        RoomElement singleRoom = new SingleRoom("Ocean View", 101);
        RoomElement doubleRoom = new DoubleRoom("Mountain View", 202);

        RoomOperationVisitor priceVisitor = new RoomPriceVisitor();
        RoomOperationVisitor housekeepingVisitor = new RoomHouseKeepingVisitor();

        singleRoom.accept(priceVisitor);

        doubleRoom.accept(housekeepingVisitor);
    }
}