package ki.optisoins.utils;

import ki.optisoins.log.OptiSoinsLogger;

import java.util.Properties;

public class PropertiesUtils {

  public static void printTraceValues(Properties properties, String nomProperties){
    OptiSoinsLogger.printTrace("Chargement du fichier de configuration : '" + nomProperties + "'");
    for (String key : properties.stringPropertyNames()){
      OptiSoinsLogger.printTrace(StringUtils.concat("=", " " + key.toString(), properties.getProperty(key)));
    }
  }
}
