package org.example;

public class StateB implements BaseState {

    @Override
    public void methodA(Entity entity) throws Exception {
        throw new Exception("method A not allowed");
    }

    @Override
    public void methodB(Entity entity) throws Exception {
        System.out.println("executing methodB");
        entity.setState(new StateC());
    }

    @Override
    public void methodC(Entity entity) throws Exception {
        throw new Exception("method C not allowed");
    }
}
