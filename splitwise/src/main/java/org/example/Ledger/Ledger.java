package org.example.Ledger;

import java.util.List;
import java.util.Map;

import org.example.User.User;
import org.example.Split.Split;

public class Ledger {
    private static int idSequencer;

    private int id;
    Map<User, List<Split>> expenseBreakup;

    public Map<User, List<Split>> getExpenseBreakup() {
        return expenseBreakup;
    }

    public void setExpenseBreakup(Map<User, List<Split>> expenseBreakup) {
        this.expenseBreakup = expenseBreakup;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGet() {
        return totalYouGet;
    }

    public void setTotalYouGet(double totalYouGet) {
        this.totalYouGet = totalYouGet;
    }

    public double getTotalYouSpent() {
        return totalYouSpent;
    }

    public void setTotalYouSpent(double totalYouSpent) {
        this.totalYouSpent = totalYouSpent;
    }

    double totalYouOwe;
    double totalYouGet;
    double totalYouSpent;

    public Ledger(Map<User, List<Split>> expenseBreakup, double totalYouOwe, double totalYouGet, double totalYouSpent) {
        this.id = ++idSequencer;
        this.expenseBreakup = expenseBreakup;
        this.totalYouOwe = totalYouOwe;
        this.totalYouGet = totalYouGet;
        this.totalYouSpent = totalYouSpent;
    }
}
