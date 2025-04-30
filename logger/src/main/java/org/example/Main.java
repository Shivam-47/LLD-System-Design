package org.example;

import org.example.LogApp.LogApp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to logging service!");

        LogApp myLogger = new LogApp();

        myLogger.debug("dummy debug log message");
        myLogger.info("dummy info log message");
        myLogger.warning("dummy warning log message");
        myLogger.error("dummy error log message");
    }
}