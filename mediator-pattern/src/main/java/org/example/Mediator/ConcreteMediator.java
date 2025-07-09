package org.example.Mediator;

import org.example.MessageReceiver.MessageReceiver;
import java.util.*;

public class ConcreteMediator implements Mediator {
    private List<MessageReceiver> users;

    public ConcreteMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, MessageReceiver sender) {
        notifyUsers(message, sender);
    }

    @Override
    public void registerUser(MessageReceiver user) {
        users.add(user);
    }

    @Override
    public void unregisterUser(MessageReceiver user) {
        users.remove(user);
    }

    @Override
    public void notifyUsers(String message, MessageReceiver sender) {
        for (MessageReceiver user : users) {
            if (user.getName() != sender.getName()) {
                user.receiveMessage(message);
            }
        }
    }
}
