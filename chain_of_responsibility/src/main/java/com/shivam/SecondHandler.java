package com.shivam;

public class SecondHandler extends BaseHandler {
    public SecondHandler(BaseHandler nextHandler){
        super(nextHandler);
    }

    @Override
    public void callMethod(int level) {
        if(level==2){
            System.out.println("callMethod for level " + level);
        } else {
            super.callMethod(level);
        }
    }
}
