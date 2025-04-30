package org.example.Logger;

import java.util.List;
import org.example.Sink.LogSink;

public class InfoLogger extends Logger {
    private static int infoSeverity = 1;

    public InfoLogger(Logger next, List<LogSink> sink){
        super(next, sink);
    }

    @Override
    public void logMessage(String message, int severity) {
        if(severity == infoSeverity){
            for(LogSink sinkObject: sink){
                sinkObject.write(formatMessage(message, "INFO"));
            }
        } else {
            super.logMessage(message, severity);
        }
    }
}
