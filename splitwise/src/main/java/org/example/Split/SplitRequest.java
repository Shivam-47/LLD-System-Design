package org.example.Split;

import org.example.User.User;

public class SplitRequest {
    private User user;
    private double amount;
    private double percentage;

    public SplitRequest(User user){
        this.user = user;
    }

    public SplitRequest(User user, double amount, double percentage) {
        this.user = user;
        this.amount = amount;
        this.percentage = percentage;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public double getPercentage() {
        return percentage;
    }

}
