package com.shivam.dependency_inversion;

//here the class has an interface
//as private attribute instead of a concrete
//class so here it can accept both
//wired and wireless keyboard
public class CorrectedMacbook {
    private final KeyboardInterface keyboard;

    public CorrectedMacbook(KeyboardInterface keyboard) {
        this.keyboard = keyboard;
    }
}
