package org.example;

import org.example.Split.SplitRequest;
import org.example.User.User;
import org.example.Group.Group;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Splitwise!");

        User userOne = new User("one");
        User userTwo = new User("two");
        User userThree = new User("three");

        Group triads = new Group("Triads", userOne);
        triads.addUser(userTwo, userOne);
        triads.addUser(userThree, userOne);
        List<SplitRequest> splitRequestList = new ArrayList<SplitRequest>();
        splitRequestList.add(new SplitRequest(userOne));
        splitRequestList.add(new SplitRequest(userTwo));
        splitRequestList.add(new SplitRequest(userThree));

        System.out.println("Starting equal splits");
        triads.splitExpense("Playstation 5", 50000.0, userOne, "equal", splitRequestList);

        userOne.printLedger();
        userTwo.printLedger();
        userThree.printLedger();

        System.out.println("Starting weighted splits");

        List<SplitRequest> splitRequestList2 = new ArrayList<SplitRequest>();
        splitRequestList2.add(new SplitRequest(userOne, 0, 20.0));
        splitRequestList2.add(new SplitRequest(userTwo, 0, 30.0));
        splitRequestList2.add(new SplitRequest(userThree, 0, 50.0));
        triads.splitExpense("Games", 10000.0, userOne, "weighted", splitRequestList2);

        userOne.printLedger();
        userTwo.printLedger();
        userThree.printLedger();
    }

}