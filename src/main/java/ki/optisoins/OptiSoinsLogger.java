package ki.optisoins;


import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

public class OptiSoinsLogger {
    private static Logger logger = Logger.getLogger(OptiSoinsLogger.class);

    public static void initLogger() throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(), "optisoins.log", false));
        logger.setLevel(getLevel());
    }

    private static Level getLevel() {
        switch (OptiSoinsProperties.getConfiguration(OptiSoinsPropertiesValue.LOGGER_LEVEL)) {
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
