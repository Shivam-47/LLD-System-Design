package org.example.RoomOperationVisitor;

import org.example.RoomElement.*;

public interface RoomOperationVisitor {
    void visit(SingleRoom room);
    void visit(DoubleRoom room);
}
