package com.shivam.dependency_inversion;


//here the class has a concrete class
//of wired keyboard as the keyboard
//and hence won't be able to accept wireless
//keyboard class
public class Macbook {
    private final WiredKeyboard keyboard;

    public Macbook(WiredKeyboard keyboard) {
        this.keyboard = keyboard;
    }
}

