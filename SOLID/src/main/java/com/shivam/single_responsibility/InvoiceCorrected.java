package com.shivam.single_responsibility;

//cleaned code
public class InvoiceCorrected {
    private Marker marker;
    private int quantity;

    public InvoiceCorrected(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateAmount() {
        return this.quantity * marker.getPrice();
    }
}
