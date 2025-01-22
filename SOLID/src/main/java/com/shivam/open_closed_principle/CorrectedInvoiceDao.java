package com.shivam.open_closed_principle;

//this implements common interface and
//hence doesn't violate Open-Close principle
public class CorrectedInvoiceDao implements InvoiceDaoInterface {
    Invoice invoice;

    public void save(Invoice invoice) {
        //saves to Db
    }
}

