package org.example.Ledger;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Ledger {

    private List<Transaction> transactionList;

    public Ledger() {
        this.transactionList = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
        System.out.printf("Successfully added transaction %s for amount %d to ledger\n", transaction.getRefId(), transaction.getAmount());
    }

    public void markTransactionAsInactive(Transaction transaction) throws Exception {

        //        this implementation is not correct it leads to ConcurrentModificationException
//        for(Transaction transactionDto : transactionList) {
//            if (transactionDto.getRefId() == transaction.getRefId()) {
//                transactionDto.markInactive();
//                transactionList.remove(transactionDto);
//                return;
//            }
//        }

        Iterator<Transaction> iterator = transactionList.iterator();

        while(iterator.hasNext()){
            Transaction tx = iterator.next();
            if(tx.getRefId().equals(transaction.getRefId())){
                tx.markInactive();
                iterator.remove();
                return;
                }
            }
        throw new Exception("Ledger err: transaction not found");
    }
}
