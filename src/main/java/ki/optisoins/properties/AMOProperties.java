package ki.optisoins.properties;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.export.etat.EtatExport;
import ki.optisoins.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class AMOProperties {
  private static Logger logger = LoggerFactory.getLogger(EtatExport.class);

  private static AMOProperties amoProperties = createAndLoadProperties();
  private Properties properties = new Properties();

  public static Properties getProperties() {
    return amoProperties.properties;
  }

  public static AMOProperties createAndLoadProperties() {
    AMOProperties amoProperties = new AMOProperties();
    amoProperties.loadProperties();
    return amoProperties;
  }

  private void loadProperties() {
    Path pathProperties = Paths.get(OptiSoinsConfiguration.amoConfiguration);
    if (Files.isReadable(pathProperties)) {
      try {
        properties.load(Files.newInputStream(pathProperties));
      } catch (IOException e) {
        logger.error("Erreur lors du chargement des AMOs", e);
        throw new RuntimeException(e);
      }
    }
  }

  public static int getAMOValue(String amo) {
    if (StringUtils.isEmpty(amo)) {
      return 0;
    }
    String amoValue = getProperties().getProperty(amo);
    if (amoValue == null) {
      throw new RuntimeException("l'AMO " + amo + " n'a pas été défini dans le fichier de configuration");
    }
    return Integer.parseInt(amoValue);
  }
}
