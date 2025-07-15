package org.example.RemoteCall;

public abstract class RemoteCall {

    private String host;
    private int timeoutInSeconds;
    private String authToken;

    public RemoteCall(String host, int timeoutInSeconds, String authToken) {
        this.host = host;
        this.timeoutInSeconds = timeoutInSeconds;
        this.authToken = authToken;
    }

    protected abstract void makeConnection();
    protected abstract void setEndpoint();
    protected abstract void injectHeaders();
    protected abstract void injectQueryParams();
    protected abstract void injectBody();

    public final void makeRequest(){
        makeConnection();
        setEndpoint();
        injectHeaders();
        injectQueryParams();
        injectBody();

        // Simulate sending the request
        System.out.println("Request sent successfully.");
    }
}
