package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    private final String logFile;

    public LogWriter(String logFile) {
        this.logFile = logFile;
    }
    
    public void writeLog(LogEntry logEntry) {
        System.out.println("Writing log to " + logFile + ": " + logEntry.getMessage());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logEntry.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
