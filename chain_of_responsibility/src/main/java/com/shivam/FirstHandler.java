package com.shivam;

public class FirstHandler extends BaseHandler {
    public FirstHandler(BaseHandler nextHandler){
        super(nextHandler);
    }

    @Override
    public void callMethod(int level) {
        if(level == 1){
            System.out.println("callMethod for level " + level);
        } else {
            super.callMethod(level);
        }
    }
}
