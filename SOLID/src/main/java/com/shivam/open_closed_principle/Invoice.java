package com.shivam.open_closed_principle;

import com.shivam.single_responsibility.Marker;

//existing code violates single responsibility
//as there are 3 reasons for the class to be changed
//change can be due to calculation of amount, printing and saving to DB
public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity){
        this.marker=marker;
        this.quantity=quantity;
    }

    public int calculateAmount(){
        return this.quantity*marker.getPrice();
    }
}


