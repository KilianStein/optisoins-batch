package ki.optisoins.properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.export.feuillesoins.IdentifiantsFeuilleSoins;
import ki.optisoins.utils.PixelUtils;

public class ConfigurationProperties {
  private static ConfigurationProperties optiSoinsProperties = createAndLoadProperties();
  private Properties properties = new Properties();
  private static boolean unDossierParExcel = false;

  public static Properties getProperties() {
    return optiSoinsProperties.properties;
  }

  public static ConfigurationProperties createAndLoadProperties() {
    ConfigurationProperties optiSoinsProperties = new ConfigurationProperties();
    optiSoinsProperties.loadProperties();
    return optiSoinsProperties;
  }

  private void loadProperties() {
    Path pathProperties = Paths.get(OptiSoinsConfiguration.fichierConfiguration);
    if (Files.isReadable(pathProperties)) {
      try {
        properties.load(Files.newInputStream(pathProperties));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static String getConfiguration(ConfigurationPropertiesValue optiSoinsPropertiesValue) {
    return getProperties().getProperty(optiSoinsPropertiesValue.getNomConfiguration());
  }

  public static boolean getConfigurationBoolean(ConfigurationPropertiesValue optiSoinsPropertiesValue) {
    return Boolean.valueOf(getConfiguration(optiSoinsPropertiesValue));
  }

  public static int getConfigurationInteger(ConfigurationPropertiesValue optiSoinsPropertiesValue) {
    return Integer.valueOf(getConfiguration(optiSoinsPropertiesValue));
  }

  public static boolean isConfigurationPresente(ConfigurationPropertiesValue optiSoinsPropertiesValue) {
    return getProperties().getProperty(optiSoinsPropertiesValue.getNomConfiguration()) != null;
  }

  public static int getMargeHaut() {
    return PixelUtils.tranformToPixel(getConfiguration(ConfigurationPropertiesValue.IMPRESSION_MARGE_HAUT));
  }

  public static int getMargeGauche() {
    return PixelUtils.tranformToPixel(getConfiguration(ConfigurationPropertiesValue.IMPRESSION_MARGE_GAUCHE));
  }

  public static IdentifiantsFeuilleSoins getIdentifiantFeuilleSoins() {
    try {
      return IdentifiantsFeuilleSoins.valueOf(getConfiguration(ConfigurationPropertiesValue.IDENTIFIANT_FEUILLE_SOINS));
    } catch (IllegalArgumentException e){
      return IdentifiantsFeuilleSoins.DEFAULT;
    }
  }

  public static boolean isUnDossierParExcel() {
    return unDossierParExcel;
  }

  public static void setUnDossierParExcel(boolean unDosssierParExcelValue) {
    unDossierParExcel = unDosssierParExcelValue;
  }
}