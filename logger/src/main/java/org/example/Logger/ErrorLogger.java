package org.example.Logger;

import java.util.List;
import org.example.Sink.LogSink;

public class ErrorLogger extends Logger {
    private static int errorSeverity = 3;

    public ErrorLogger(Logger next, List<LogSink> sink){
        super(next, sink);
    }

    @Override
    public void logMessage(String message, int severity) {
        if(severity == errorSeverity){
            for(LogSink sinkObject: sink){
                sinkObject.write(formatMessage(message, "ERROR"));
            }
        } else {
            super.logMessage(message, severity);
        }
    }
}
