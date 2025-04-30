package org.example.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import org.example.Sink.ConsoleSink;
import org.example.Sink.LogSink;

public class Logger {
    private Logger next;
    protected List<LogSink> sink;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public Logger(Logger next, List<LogSink> sink){
        this.next = next;
        if(sink == null){
            sink = new ArrayList<LogSink>();
            sink.add(new ConsoleSink());
        }
        this.sink = sink;
    }

    protected String formatMessage(String message, String prefix){
        return LocalDateTime.now().format(formatter) + " [" + Thread.currentThread().getName() + "] " + prefix + ":" + message;
    }

    public void logMessage(String message, int severity){
        if(this.next != null){
            this.next.logMessage(message, severity);
        } else {
            System.out.println("Error occurred when logging the message");
        }
    }
}
