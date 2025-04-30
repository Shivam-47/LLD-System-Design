package org.example.LogApp;

import org.example.Logger.*;
import org.example.Sink.ConsoleSink;
import org.example.Sink.FileSink;
import org.example.Sink.LogSink;

import java.util.List;
import java.util.ArrayList;

public class LogApp {
    private Logger logger;

    public LogApp() {
        List<LogSink> logSinks = new ArrayList<LogSink>();
        logSinks.add(new ConsoleSink());
        logSinks.add(new FileSink("log.txt"));

        logger = new DebugLogger(
                    new InfoLogger(
                        new WarningLogger(
                            new ErrorLogger(null, logSinks),
                                logSinks),
                            logSinks),
                logSinks);
    }

    public void debug(String message){
        this.logger.logMessage(message, 0);
    }

    public void info(String message){
        this.logger.logMessage(message, 1);
    }

    public void warning(String message){
        this.logger.logMessage(message, 2);
    }

    public void error(String message){
        this.logger.logMessage(message, 3);
    }
}
