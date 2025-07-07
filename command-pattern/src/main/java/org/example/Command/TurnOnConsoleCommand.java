package org.example.Command;

import org.example.Receiver.PlaystationConsole;

public class TurnOnConsoleCommand implements Command {

    private PlaystationConsole console;

    public TurnOnConsoleCommand(PlaystationConsole console) {
        this.console = console;
    }

    @Override
    public void execute() {
        //business-logic
        this.console.turnOn();
        this.console.turnOnFan();
    }
}
