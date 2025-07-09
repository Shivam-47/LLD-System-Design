package org.example.Mediator;

import org.example.MessageReceiver.MessageReceiver;

public interface Mediator {
    void sendMessage(String message, MessageReceiver sender);
    void registerUser(MessageReceiver user);
    void unregisterUser(MessageReceiver user);
    void notifyUsers(String message, MessageReceiver sender);

}
