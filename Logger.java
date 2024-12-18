package log;

import java.util.*;
import java.util.concurrent.*;

public class Logger {
    private final LogWriter logWriter;
    private final LogLevel currentLogLevel;
    private final Map<String, Long> processStartTimes;
    private final Queue<String> eventQueue;
    private final ExecutorService executor;

    // Constructor takes log file name and current log level
    public Logger(String logFile, LogLevel currentLogLevel) {
        this.logWriter = new LogWriter(logFile);
        this.currentLogLevel = currentLogLevel;
        this.processStartTimes = new HashMap<>();
        this.eventQueue = new LinkedList<>();
        this.executor = Executors.newSingleThreadExecutor();
    }

    // Method to log messages
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            LogEntry logEntry = new LogEntry(level, message);
            logWriter.writeLog(logEntry);
        }
    }

    // Start method for a process (record the start time)
    public void start(String processId) {
        long startTime = System.currentTimeMillis();
        processStartTimes.put(processId, startTime);
        log(LogLevel.INFO, "Started process: " + processId + " at " + startTime);
    }

    // End method for a process (record the end time)
    public void end(String processId) {
        Long startTime = processStartTimes.get(processId);
        if (startTime != null) {
            long endTime = System.currentTimeMillis();
            log(LogLevel.INFO, "Ended process: " + processId + " at " + endTime);
            log(LogLevel.DEBUG, "Process " + processId + " duration: " + (endTime - startTime) + " ms");
            eventQueue.add(processId);
        }
    }

    // Poll method to retrieve the next process from the queue
    public void poll() {
        if (!eventQueue.isEmpty()) {
            String processId = eventQueue.poll();
            log(LogLevel.INFO, "Polling process: " + processId);
        } else {
            log(LogLevel.DEBUG, "No processes to poll.");
        }
    }

    // Convenience methods for different log levels
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    
}
