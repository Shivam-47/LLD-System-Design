package org.example;

import org.example.RemoteCall.CatalogRemoteCall;
import org.example.RemoteCall.SearchRemoteCall;
import org.example.RemoteCall.SellerRemoteCall;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome to template pattern!");

        CatalogRemoteCall catalogRemoteCall = new CatalogRemoteCall("http://cms.example.com", 30, "authToken123");
        SellerRemoteCall sellerRemoteCall = new SellerRemoteCall("http://seller.example.com", 30, "authToken123");
        SearchRemoteCall searchRemoteCall = new SearchRemoteCall("http://search.example.com", 30, "authToken123");

        catalogRemoteCall.makeRequest();
        sellerRemoteCall.makeRequest();
        searchRemoteCall.makeRequest();
    }
}