package com.shivam;

public class ThirdHandler extends BaseHandler {
    public ThirdHandler(BaseHandler baseHandler){
        super(baseHandler);
    }

    @Override
    public void callMethod(int level) {
        if(level==3){
            System.out.println("callMethod for level " + level);
        } else {
            super.callMethod(level);
        }
    }
}
