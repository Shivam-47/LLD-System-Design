package org.example;

public class StateA implements BaseState {

    @Override
    public void methodA(Entity entity) throws Exception {
        System.out.println("executing methodA");
        entity.setState(new StateB());
    }

    @Override
    public void methodB(Entity entity) throws Exception {
        throw new Exception("method B not allowed");
    }

    @Override
    public void methodC(Entity entity) throws Exception {
        throw new Exception("method C not allowed");
    }
}
