package org.example.RemoteCall;

public class CatalogRemoteCall extends RemoteCall {

    public CatalogRemoteCall(String host, int timeoutInSeconds, String authToken) {
        super(host, timeoutInSeconds, authToken);
    }

    @Override
    protected void makeConnection() {
        System.out.println("Connecting to the catalog service...");
    }

    @Override
    protected void setEndpoint() {
        System.out.println("Setting endpoint to /catalog");
    }

    @Override
    protected void injectHeaders() {
        System.out.println("Injecting headers for catalog service request...");
    }

    @Override
    protected void injectQueryParams() {
        System.out.println("Injecting query parameters for catalog service request...");
    }

    @Override
    protected void injectBody() {
        System.out.println("Injecting body for catalog service request...");
    }
}
