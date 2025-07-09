package org.example.User;

import org.example.Mediator.Mediator;
import org.example.MessageReceiver.MessageReceiver;

public class ConcreteUser implements User, MessageReceiver {
    private String name;
    private Mediator mediator;

    public ConcreteUser(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.registerUser(this);
    }

    @Override
    public void sendMessage(String message) {
        System.out.printf("%s sends: %s\n", name, message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.printf("%s receives: %s\n", name, message);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void unregister() {
        mediator.unregisterUser(this);
        System.out.printf("%s has been unregistered from the mediator.\n", name);
    }
}
