package org.example;

import org.example.Command.TurnOffConsoleCommand;
import org.example.Command.TurnOnConsoleCommand;
import org.example.Receiver.PlaystationConsole;
import org.example.RemoteController.DualSenseController;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to command pattern!");

        PlaystationConsole ps = new PlaystationConsole();
        DualSenseController controller = new DualSenseController();

        System.out.println("Turning on console");
        controller.setCurrentCommand(new TurnOnConsoleCommand(ps));
        controller.executeCurrentCommand();

        System.out.println("Turning off console");
        controller.setCurrentCommand(new TurnOffConsoleCommand(ps));
        controller.executeCurrentCommand();
    }
}