package ki.optisoins.properties;

import ki.optisoins.OptiSoinsConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationProperties {
    private static ConfigurationProperties optiSoinsProperties = createAndLoadProperties();
    private Properties properties = new Properties();


    public Properties getProperties() {
        return properties;
    }

    public static ConfigurationProperties createAndLoadProperties() {
        ConfigurationProperties optiSoinsProperties = new ConfigurationProperties();
        optiSoinsProperties.loadProperties();
        return optiSoinsProperties;
    }

    private void loadProperties() {
        Path pathProperties = Paths.get(OptiSoinsConfiguration.fichierConfiguration);
        if (Files.isReadable(pathProperties)){
            try {
                properties.load(Files.newInputStream(pathProperties));
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }
        }
    }

    public static String getConfiguration(ConfigurationPropertiesValue optiSoinsPropertiesValue){
        return optiSoinsProperties.getProperties().getProperty(optiSoinsPropertiesValue.getNomConfiguration());
    }

    public static boolean getConfigurationBoolean(ConfigurationPropertiesValue optiSoinsPropertiesValue){
        return Boolean.valueOf(getConfiguration(optiSoinsPropertiesValue));
    }

    public static int getConfigurationInteger(ConfigurationPropertiesValue optiSoinsPropertiesValue){
        return Integer.valueOf(getConfiguration(optiSoinsPropertiesValue));
    }

    public static boolean isConfigurationPresente(ConfigurationPropertiesValue optiSoinsPropertiesValue) {
        return optiSoinsProperties.getProperties().getProperty(optiSoinsPropertiesValue.getNomConfiguration()) != null;
    }

}
