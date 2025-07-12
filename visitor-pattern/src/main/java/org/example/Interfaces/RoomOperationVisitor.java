package org.example.Interfaces;

import org.example.RoomElement.*;

public interface RoomOperationVisitor {
    void visit(SingleRoom room);
    void visit(DoubleRoom room);
}
