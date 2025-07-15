package org.example.RemoteCall;

public class SearchRemoteCall extends RemoteCall {

    public SearchRemoteCall(String host, int timeoutInSeconds, String authToken) {
        super(host, timeoutInSeconds, authToken);
    }

    @Override
    protected void makeConnection() {
        System.out.println("Connecting to the search service...");
    }

    @Override
    protected void setEndpoint() {
        System.out.println("Setting endpoint to /search");
    }

    @Override
    protected void injectHeaders() {
        System.out.println("Injecting headers for search service request...");
    }

    @Override
    protected void injectQueryParams() {
        System.out.println("Injecting query parameters for search service request...");
    }

    @Override
    protected void injectBody() {
        System.out.println("Injecting body for search service request...");
    }
}
