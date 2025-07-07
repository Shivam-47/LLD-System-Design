package org.example.RemoteController;

import org.example.Command.Command;

public class DualSenseController {
    private Command currentCommand;

    public DualSenseController() {

    }

    public void setCurrentCommand(Command currentCommand) {
        this.currentCommand = currentCommand;
    }

    public void executeCurrentCommand() {
        this.currentCommand.execute();
    }
}
