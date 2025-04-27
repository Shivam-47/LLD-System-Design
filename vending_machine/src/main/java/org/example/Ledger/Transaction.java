package org.example.Ledger;

import java.util.UUID;

public class Transaction {

    public enum TransactionType {
        CREDIT,DEBIT;
    }

    public String getRefId() {
        return refId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Integer getAmount() {
        return amount;
    }

    public Boolean getActiveFlag() {
        return isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    private String refId;
    private TransactionType transactionType;

    private Integer amount;

    private Boolean isActive;

    public Transaction(TransactionType transactionType, Integer amount){
        this.refId = UUID.randomUUID().toString();
        this.transactionType = transactionType;
        this.amount = amount;
        this.isActive=true;
    }

    public void markInactive(){
        this.isActive = false;
    }

    public void markActive(){
        this.isActive = true;
    }
}
