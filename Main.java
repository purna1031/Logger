package log;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger("application.log", LogLevel.DEBUG);

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.error("This is an error message");

            logger.start("1");
            logger.poll();
            logger.end("1");
    
            logger.start("2");
            logger.poll();
            logger.end("2");
    
            logger.start("3");
            logger.poll();
            logger.end("3");
    
            logger.poll(); 
    
}
}