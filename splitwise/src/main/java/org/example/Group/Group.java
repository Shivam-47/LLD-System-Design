package org.example.Group;

import org.example.Expense.Expense;
import org.example.Split.SplitRequest;
import org.example.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Group {
    private static int idSequence;

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<User> getAdmins() {
        return admins;
    }

    List<User> members;
    List<User> admins;

    public Group(String name, User user){
        this.id = ++idSequence;
        this.members = new ArrayList<User>();
        this.admins = new ArrayList<User>();
        this.members.add(user);
        this.admins.add(user);

    }

    public void addUser(User user, User addedBy){
        if (this.admins.contains(addedBy)) {
            this.members.add(user);
        } else {
            System.out.println("unable to add user as " + addedBy.getName() + " " +
                    "is not admin for group "+this.id +" : "+this.name);
        }
    }

    public void removeUser(User user, User addedBy){
        if (this.admins.contains(addedBy)) {
            this.members.remove(user);
        } else {
            System.out.println("unable to add user as " + addedBy.getName() + " " +
                    "is not admin for group "+this.id +" : "+this.name);
        }
    }

    public void splitExpense(String expenseName, double amount, User paidBy, String splitType, List<SplitRequest> splitRequests) {
        try {
            Expense expense = new Expense(expenseName, amount, paidBy, this.members, splitType);
            expense.splitExpense(splitRequests);
        } catch (Exception e){
            System.out.println("Exception: unable to split expense " + e);
        }
    }
}
