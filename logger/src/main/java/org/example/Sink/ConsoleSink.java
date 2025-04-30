package org.example.Sink;

public class ConsoleSink implements LogSink{
    public ConsoleSink(){

    };

    @Override
    public void write(String message){
        System.out.println(message);
    }
}
