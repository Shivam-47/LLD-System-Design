package org.example.Command;

import org.example.Receiver.PlaystationConsole;

public class TurnOffConsoleCommand implements Command {
    private PlaystationConsole console;

    public TurnOffConsoleCommand(PlaystationConsole console) {
        this.console = console;
    }

    @Override
    public void execute() {
        //business-logic
        this.console.turnOffFan();
        this.console.turnOff();
    }

    @Override
    public void undo() {
        //business-logic
        this.console.turnOnFan();
        this.console.turnOn();
    }
}
