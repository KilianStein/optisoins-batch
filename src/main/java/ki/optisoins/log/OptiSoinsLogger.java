package ki.optisoins.log;

import ki.optisoins.OptiSoins;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptiSoinsLogger {
  private static Logger logger = LoggerFactory.getLogger(OptiSoins.class);


  public static void printError(String message) {
    logger.error(message);
  }

  public static void printError(String message, Throwable t) {
    logger.error(message, t);
  }

  public static void printWarning(String message, Throwable t) {
    logger.warn(message, t);
  }

  public static void printWarning(String message) {
    logger.warn(message);
  }

  public static void printDebug(String message) {
    logger.debug(message);
  }

  public static void printTrace(String message) {
    logger.trace(message);
  }
}
