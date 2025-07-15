package org.example.RemoteCall;

public class SellerRemoteCall extends RemoteCall{
    public SellerRemoteCall(String host, int timeoutInSeconds, String authToken) {
        super(host, timeoutInSeconds, authToken);
    }

    @Override
    protected void makeConnection() {
        System.out.println("Connecting to the seller service...");
    }

    @Override
    protected void setEndpoint() {
        System.out.println("Setting endpoint to /seller");
    }

    @Override
    protected void injectHeaders() {
        System.out.println("Injecting headers for seller service request...");
    }

    @Override
    protected void injectQueryParams() {
        System.out.println("Injecting query parameters for seller service request...");
    }

    @Override
    protected void injectBody() {
        System.out.println("Injecting body for seller service request...");
    }
}
