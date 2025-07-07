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
        System.out.println("Hello and welcome to command pattern!");
        System.out.print("\n\n");

        PlaystationConsole ps = new PlaystationConsole();
        DualSenseController controller = new DualSenseController();

        //try to undo without any command
        controller.undoCommand();
        System.out.print("\n\n");

        System.out.println("Turning on console");
        controller.setCurrentCommand(new TurnOnConsoleCommand(ps));
        controller.executeCurrentCommand();
        System.out.print("\n\n");

        System.out.println("Undo : Turning on console");
        controller.undoCommand();
        System.out.print("\n\n");

        System.out.println("Turning off console");
        controller.setCurrentCommand(new TurnOffConsoleCommand(ps));
        controller.executeCurrentCommand();
        System.out.print("\n\n");

        System.out.println("Undo : Turning off console");
        controller.undoCommand();
        System.out.print("\n\n");

        System.out.println("Undo of Undo : Turning off console");
        controller.undoCommand();
        System.out.print("\n\n");

        System.out.println("Undo of Undo of Undo : Turning off console");
        controller.undoCommand();
        System.out.print("\n\n");

        System.out.println("Redo of Undo of Undo of Undo : Turning off console");
        controller.redoCommand();
        System.out.print("\n\n");
    }
}