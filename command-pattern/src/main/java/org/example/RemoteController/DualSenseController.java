package org.example.RemoteController;

import org.example.Command.Command;
import org.example.Command.UndoWrapperCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class DualSenseController {
    private Command currentCommand;

    private static int maxHistoryLimit = 2;
    private Deque<Command> commandHistory;

    public DualSenseController() {
        this.commandHistory = new ArrayDeque<>();
    }

    public void setCurrentCommand(Command currentCommand) {
        this.currentCommand = currentCommand;
        this.addCommandToHistory(currentCommand);
    }

    public void executeCurrentCommand() {
        this.currentCommand.execute();
    }

    private void addCommandToHistory(Command command){
        if(this.commandHistory.size() == maxHistoryLimit){
            this.commandHistory.removeFirst();
        }

        this.commandHistory.addLast(command);
    }

    public void undoCommand() {
        Command lastCommand = this.commandHistory.pollLast();
        if (lastCommand == null) {
            System.out.println("No command to undo!");
            return;
        }

        UndoWrapperCommand undoWrapperCommand = new UndoWrapperCommand(lastCommand);
        undoWrapperCommand.execute();
        this.addCommandToHistory(undoWrapperCommand);
    }

    public void redoCommand() {
        Command lastCommand = this.commandHistory.pollLast();
        if (lastCommand == null) {
            System.out.println("No command to undo!");
            return;
        }

        lastCommand.execute();
        this.addCommandToHistory(lastCommand);
    }
}
