#Logger Low Level Design
A Java-based logging utility designed to streamline the process of recording, managing, and monitoring application logs. This lightweight and efficient system enables developers to track various levels of log entries, ensuring seamless debugging, performance tracking, and event analysis.

#Features
**Log Levels:** Supports multiple log levels (INFO, DEBUG, WARN, ERROR) to filter and categorize logs effectively.
**Flexible Log Writing**: Configurable log writers for console or file-based output.


#Project Structure
The repository consists of five key Java files:

##1.LogLevel.java
Defines the various levels of logging (e.g., INFO, DEBUG, WARN, ERROR). Each level helps categorize logs based on their priority and relevance.

##2.LogEntry.java
Represents a single log entry, encapsulating essential details like:
Timestamp
Log level
Message
This class ensures a structured format for all log data.

##3.LogWriter.java
Responsible for writing log entries to specific output destinations. Features include:

Writing logs to the console for quick debugging.
Support for file-based logging to maintain persistent records.
Extensibility for custom output streams.

##4.Logger.java
The core class managing the logging process. It:

Handles log creation at different levels (INFO, DEBUG, WARN, ERROR).
Utilizes LogWriter to dispatch logs to configured outputs.
Provides a thread-safe API to ensure consistent logging in concurrent environments.

##5.Main.java
Demonstrates the usage of the logger system with practical examples. Includes:
Setting up the logger.
Logging messages at various levels.
Customizing output using LogWriter.

**Documentation:**
[Logger_System.pdf](https://github.com/user-attachments/files/18194957/Logger_System.pdf)
