package org.example.Command;

public class UndoWrapperCommand implements Command {
    private Command originalCommand;

    public UndoWrapperCommand(Command originalCommand) {
        this.originalCommand = originalCommand;
    }

    @Override
    public void execute() {
        this.originalCommand.undo();
    }

    @Override
    public void undo() {
        this.originalCommand.execute();
    }
}
