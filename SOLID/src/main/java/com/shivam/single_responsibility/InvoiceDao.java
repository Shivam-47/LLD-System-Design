package com.shivam.single_responsibility;

//only reason to change
//which is saving to DB
public class InvoiceDao {
    private InvoiceCorrected invoice;

    public InvoiceDao(InvoiceCorrected invoice){
        this.invoice = invoice;
    }

    public void saveToDb(){
        //saves invoice to DB
    }
}
