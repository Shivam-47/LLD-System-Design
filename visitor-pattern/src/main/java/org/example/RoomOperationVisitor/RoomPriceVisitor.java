package org.example.RoomOperationVisitor;

import org.example.RoomElement.*;

public class RoomPriceVisitor implements  RoomOperationVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Calculating price for Single Room: " + room.getRoomName() + " with number: " + room.getRoomNumber());
        // Add logic to calculate price for Single Room
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Calculating price for Double Room: " + room.getRoomName() + " with number: " + room.getRoomNumber());
        // Add logic to calculate price for Double Room
    }
}
