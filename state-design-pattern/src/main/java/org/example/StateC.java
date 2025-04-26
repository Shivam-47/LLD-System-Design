package org.example;

public class StateC implements BaseState {

    @Override
    public void methodA(Entity entity) throws Exception {
        throw new Exception("method A not allowed");
    }

    @Override
    public void methodB(Entity entity) throws Exception {
        throw new Exception("method B not allowed");
    }

    @Override
    public void methodC(Entity entity) throws Exception {
        System.out.println("executing methodC");
        entity.setState(new StateA());
    }
}
