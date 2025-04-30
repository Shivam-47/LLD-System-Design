package org.example.Sink;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSink implements LogSink {

    private String filepath;

    public FileSink(String filepath){
        this.filepath = filepath;
    }

    @Override
    public void write(String message) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(filepath, true)));
            writer.println(message);
            writer.flush();
        } catch (IOException e){
            System.err.println("Error writing to log file: " + e.getMessage());
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
