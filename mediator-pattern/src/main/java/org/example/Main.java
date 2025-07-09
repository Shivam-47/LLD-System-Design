package org.example;

import org.example.Mediator.ConcreteMediator;
import org.example.Mediator.Mediator;
import org.example.User.ConcreteUser;
import org.example.User.User;


public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome to Mediator pattern!\n");

        Mediator auctionMediator = new ConcreteMediator();

        User auctionUser = new ConcreteUser("User1", auctionMediator);
        User auctionUser2 = new ConcreteUser("User2", auctionMediator);
        User auctionUser3 = new ConcreteUser("User3", auctionMediator);

        auctionUser.sendMessage("Bid for 10$");
        auctionUser2.sendMessage("Bid for 11$");
        auctionUser3.sendMessage("Bid for 15$");

        auctionUser.unregister();

        auctionUser2.sendMessage("Bid for 20$");
    }
}