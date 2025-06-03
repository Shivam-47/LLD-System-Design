package org.example.Expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.Ledger.Ledger;
import org.example.Split.Split;
import org.example.Split.SplitRequest;
import org.example.SplitStrategy.SplitStrategy;
import org.example.SplitStrategy.SplitStrategyFactory;
import org.example.User.User;

public class Expense {
    private int idSequencer;
    private int id;
    private String name;
    private double amount;
    private User paidBy;
    private List<User> participants;

    private String splitType; //todo make it an enum

    private SplitStrategyFactory splitFactory;

    public Expense(String name, double amount, User paidBy, List<User> participants, String splitType){
        this.id = ++idSequencer;
        this.amount = amount;
        this.paidBy = paidBy;
        this.participants = participants;
        this.splitType = splitType;
        this.splitFactory = new SplitStrategyFactory();
    }

    public void splitExpense(List<SplitRequest> splitRequests) throws Exception {
        SplitStrategy splitStrategy = this.splitFactory.getStrategyFromSplitType(this.splitType);
        //todo enhance this to get exact error message to user
        boolean isValid = splitStrategy.validateAmount(this.amount, splitRequests);
        if (!isValid){
            throw new Exception("invalid split requests passed. please verify and enter valid details");
        }

        Map<User, Double> splits = splitStrategy.splitAmount(amount, splitRequests);
        this.updateParticipantsLedger(splits);
        this.updatePaidByLedger(splits);
    }

    private void updateParticipantsLedger(Map<User,Double> splits) throws Exception{
        User paidBy = this.paidBy;
        for(User participant : this.participants){
            if (participant.getId() == this.paidBy.getId()) {
                continue;
            }

            Double splitAmount = splits.get(participant);
            if (splitAmount == null){
                System.out.println("User name : " +participant.getName() + " not present in splits");
                throw new Exception("Participant User missing from splits");
            }

            Ledger participantLedger = participant.getLedger();

            //update amount they owe
            Double participantAmountOwe = participantLedger.getTotalYouOwe() + splitAmount;
            participantLedger.setTotalYouOwe(participantAmountOwe);

            //update their ledger for the entry of paid by
            //-ve because they owe it to the paid by user
            Split split = new Split(-splitAmount, this.id);
            Map<User,List<Split>> paidByBreakup = participantLedger.getExpenseBreakup();
            if(paidByBreakup == null){
                paidByBreakup = new HashMap<User, List<Split>>();
            }

            List<Split> paidByExpense = paidByBreakup.get(paidBy);
            if (paidByExpense == null){
                List<Split> paidBySplits = new ArrayList<Split>();
                paidBySplits.add(split);
                paidByBreakup.put(paidBy, paidBySplits);
            } else {
                paidByExpense.add(split);
                paidByBreakup.put(paidBy, paidByExpense);
            }
            participantLedger.setExpenseBreakup(paidByBreakup);
        }
    }

    private void updatePaidByLedger(Map<User,Double> splits) throws Exception {
        User paidBy = this.paidBy;
        Ledger paidByLedger = paidBy.getLedger();

        //update total spent
        Double totalSpent = paidByLedger.getTotalYouSpent() + this.amount;
        paidByLedger.setTotalYouSpent(totalSpent);

        //update total you get
        Double splitAmount = splits.get(paidBy);
        if(splitAmount == null){
            System.out.println("Split missing for the paid by User name: " + paidBy.getName());
            throw new Exception("Split missing for the paid by user");
        }

        //balance will always be positive
        Double balance = this.amount-splitAmount;
        Double totalYouGet = paidByLedger.getTotalYouGet() + balance;
        paidByLedger.setTotalYouGet(totalYouGet);

        //update breakup
        Map<User, List<Split>> breakups = paidByLedger.getExpenseBreakup();
        if (breakups == null){
            breakups = new HashMap<User, List<Split>>();
        }

        for(User user: this.participants){
            if(user.getId() == this.paidBy.getId()){
                continue;
            }

            Double amount = splits.get(user);
            if (amount == null) {
                System.out.println("User name : " +user.getName() + " not present in splits");
                throw new Exception("Participant User missing from splits");
            }
            Split split = new Split(amount, this.id);
            List<Split> existingUserSplit = breakups.get(user);

            if(existingUserSplit == null){
                List<Split> userSplits = new ArrayList<Split>();
                userSplits.add(split);
                breakups.put(user, userSplits);
            } else {
                existingUserSplit.add(split);
                breakups.put(user, existingUserSplit);
            }
        }
        paidByLedger.setExpenseBreakup(breakups);

        //no changes in total you owe here
    }
}
