package org.example.RoomElement;

import org.example.RoomOperationVisitor.RoomOperationVisitor;

public class DoubleRoom implements RoomElement {
    private String roomName;
    private int roomNumber;

    public DoubleRoom(String roomName, int roomNumber) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void accept(RoomOperationVisitor visitor) {
        visitor.visit(this);
    }
}
