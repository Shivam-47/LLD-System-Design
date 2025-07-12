package org.example.RoomElement;

import org.example.RoomOperationVisitor.RoomOperationVisitor;

public interface RoomElement {
    void accept(RoomOperationVisitor visitor);

}
