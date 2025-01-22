package com.shivam.open_closed_principle;


//given class violates Open-Close principle
//as we have to modify already tested
//class when we add the support for saveToFile
public class InvoiceDao {
    Invoice invoice;


    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDb(){
        //saves to Db
    }

    public void saveToFile(){
        //saves to File
    }
}
