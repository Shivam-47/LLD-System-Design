package org.example.Logger;

import java.util.List;
import org.example.Sink.LogSink;

public class DebugLogger extends Logger {

    private static int debugSeverity = 0;

    public DebugLogger(Logger next, List<LogSink> sink){
        super(next, sink);
    }

    @Override
    public void logMessage(String message, int severity) {
        if(severity == debugSeverity){
            for(LogSink sinkObject: sink){
                sinkObject.write(formatMessage(message, "DEBUG"));
            }
        } else {
            super.logMessage(message, severity);
        }
    }
}
