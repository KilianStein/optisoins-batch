package ki.optisoins.log;


import ki.optisoins.OptiSoins;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.properties.ConfigurationPropertiesValue;
import org.apache.log4j.*;

import java.io.IOException;

public class OptiSoinsLogger {
    private static Logger logger = getLogger();;

    private static Logger getLogger() {
        Logger logger = Logger.getLogger(OptiSoins.class);
        try {
            logger.addAppender(new FileAppender(new SimpleLayout(), "optisoins.log", false));
            logger.addAppender(getConsoleAppender());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setLevel(getLevel());
        return logger;
    }

    private static ConsoleAppender getConsoleAppender(){
        ConsoleAppender ca = new ConsoleAppender();
        ca.setName("console");
        ca.setLayout(new SimpleLayout());
        ca.activateOptions();
        return ca;
    }

    private static Level getLevel() {
        switch (ConfigurationProperties.getConfiguration(ConfigurationPropertiesValue.LOGGER_LEVEL)) {
            case "ERROR":
                return Level.ERROR;
            case "DEBUG":
                return Level.DEBUG;
            case "TRACE":
                return Level.TRACE;
            default:
                return Level.ERROR;
        }
    }

    public static void printError(Object message) {
        logger.error(message);
    }


    public static void printDebug(Object message) {
        logger.debug(message);
    }


    public static void printTrace(Object message) {
        logger.trace(message);
    }

}
