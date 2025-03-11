package com.shivam;

public abstract class BaseHandler {
    private BaseHandler nextHandler;

    public BaseHandler(BaseHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void callMethod(int level){
        if(this.nextHandler != null){
            this.nextHandler.callMethod(level);
        } else {
            System.out.println("No handler found for level " + level);
        }
    }
}
