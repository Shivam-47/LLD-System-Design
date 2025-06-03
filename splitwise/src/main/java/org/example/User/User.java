package org.example.User;

import org.example.Split.Split;
import org.example.Ledger.Ledger;
import org.example.Split.SplitRequest;

import java.util.Map;
import java.util.List;


public class User {
    private static int idSequance;

    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public int[] getGroupIds() {
        return groupIds;
    }

    private String name;
    private List<User> friends;
    private int[] groupIds;

    private Ledger ledger;

    public User(String name){
        this.id = ++idSequance;
        this.name = name;
        this.ledger = new Ledger(null, 0.0,0.0,0.0);
    }

    public void addFriend(User user, User friend){
        this.friends.add(friend);
    }

    public void removeFriend(User user, User friend){
        this.friends.remove(friend);
    }

    public Ledger getLedger() {
        return ledger;
    }

    public void printLedger(){
        System.out.println("Ledger for user : "+this.getName());
        System.out.println("Total you spent = " + this.ledger.getTotalYouSpent());
        System.out.println("Total you get = " + this.ledger.getTotalYouGet());
        System.out.println("Total you owe = " + this.ledger.getTotalYouOwe());

        Map<User, List<Split>>  breakups = ledger.getExpenseBreakup();

        for(Map.Entry<User, List<Split>> entry: breakups.entrySet()){
            User user = entry.getKey();
            List<Split> splits = entry.getValue();

            System.out.println("User : " + user.getName());
            for(Split split: splits){
                System.out.println("Expense id : " + split.getExpenseId() + " Amount : " + split.getAmount());
            }
        }

        System.out.println("------END------");
    }
}
