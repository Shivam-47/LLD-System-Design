package com.shivam.open_closed_principle;

import com.shivam.open_closed_principle.Invoice;

//this implements common interface and
//hence doesn't violate Open-Close principle
interface InvoiceDaoInterface {
    public void save(Invoice invoice);
}