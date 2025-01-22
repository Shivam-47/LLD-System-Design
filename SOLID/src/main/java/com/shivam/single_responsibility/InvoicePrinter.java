package com.shivam.single_responsibility;

//only 1 reason to change
//which is to change print logic
public class InvoicePrinter {
    private InvoiceCorrected invoice;

    public InvoicePrinter(InvoiceCorrected invoice) {
        this.invoice = invoice;
    }

    public void printInvoice(){
        //prints invoice
    }
}
