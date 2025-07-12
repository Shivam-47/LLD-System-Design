package org.example.RoomOperationVisitor;

import org.example.RoomElement.*;

public class RoomHouseKeepingVisitor implements RoomOperationVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Housekeeping for Single Room: " + room.getRoomName() + " (Room Number: " + room.getRoomNumber() + ")");
        // Additional housekeeping logic for single rooms
    }

    public void visit(DoubleRoom room) {
        System.out.println("Housekeeping for Double Room: " + room.getRoomName() + " (Room Number: " + room.getRoomNumber() + ")");
        // Additional housekeeping logic for double rooms
    }
}
