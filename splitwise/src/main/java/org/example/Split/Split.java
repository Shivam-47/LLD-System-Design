package org.example.Split;

public class Split {
    private static int idSequencer;

    private int id;

    public double getAmount() {
        return amount;
    }

    public int getExpenseId() {
        return expenseId;
    }

    private double amount;
    private int expenseId;

    public Split(double amount, int expenseId) {
        this.id = ++idSequencer;
        this.amount = amount;
        this.expenseId = expenseId;
    }
}
