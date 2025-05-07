package org.example.AtmMachine;

import org.example.AtmState.AtmState;
import org.example.AtmState.IdleState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AtmMachine {

    private Map<Integer, Integer> currencyInventory;

    private static int[] denominations = {1000,500,100};

    private AtmState atmState;

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public AtmState getAtmState(){
        return this.atmState;
    }

    public AtmMachine(){
        initInventory();
        this.atmState = new IdleState();
    }

    private void initInventory(){
        this.currencyInventory = new HashMap<Integer, Integer>();
        this.currencyInventory.put(1000, 10);
        this.currencyInventory.put(500, 2);
        this.currencyInventory.put(100,2);
    }

    public Integer getInventory(Integer currencyDenomination) {
        return this.currencyInventory.get(currencyDenomination);
    }

    public void decrementInventory(Integer currencyDenomination, Integer value) {
        Integer currentInventory = this.currencyInventory.get(currencyDenomination);
        this.currencyInventory.put(currencyDenomination, currentInventory-value);
    }

    public void incrementInventory(Integer currencyDenomination, Integer value) {
        Integer currentInventory = this.currencyInventory.get(currencyDenomination);
        this.currencyInventory.put(currencyDenomination, currentInventory+value);
    }

    public Integer getRemainingBalance() {
        Integer balance = 0;

        for(Entry<Integer,Integer> entry : this.currencyInventory.entrySet()){
            Integer denomination = entry.getKey();
            Integer inventory = entry.getValue();

            balance += denomination*inventory;
        }

        return balance;
    }

    public Boolean possibleToWithdrawAmount(Integer amount){
        for(int i=0;i<3;i++){
            Integer denomination = denominations[i];
            if(amount >= denomination){
                Integer requiredBills = amount/denomination;
                amount = amount -  Math.min(requiredBills, this.currencyInventory.get(denomination))*denomination;
            }

            if(amount == 0)
                return true;
        }

        return false;
    }
}
