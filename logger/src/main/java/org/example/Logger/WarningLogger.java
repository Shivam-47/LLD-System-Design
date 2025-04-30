package org.example.Logger;

import java.util.List;
import org.example.Sink.LogSink;

public class WarningLogger extends Logger {
    private static int warningSeverity = 2;

    public WarningLogger(Logger next, List<LogSink> sink){
        super(next, sink);
    }

    @Override
    public void logMessage(String message, int severity) {
        if(severity == warningSeverity){
            for(LogSink sinkObject: sink){
                sinkObject.write(formatMessage(message, "WARNING"));
            }
        } else {
            super.logMessage(message, severity);
        }
    }
}
