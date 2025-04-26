package org.example;

public class Entity {
    private BaseState state;

    public Entity(){
        this.state = new StateA();
    }

    public void setState(BaseState state){
        this.state = state;
    }

    public BaseState getState() {
        return this.state;
    }
}
