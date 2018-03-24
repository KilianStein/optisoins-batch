package ki.optisoins.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PropertiesUtils {
  private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

  public static void printTraceValues(Properties properties, String nomProperties){
    logger.trace("Chargement du fichier de configuration : '{}'", nomProperties);
    for (String key : properties.stringPropertyNames()){
      logger.trace(StringUtils.concat("=", " " + key.toString(), properties.getProperty(key)));
    }
  }
}
