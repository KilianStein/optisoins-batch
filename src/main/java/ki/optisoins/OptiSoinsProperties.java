package ki.optisoins;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class OptiSoinsProperties {
    private static OptiSoinsProperties optiSoinsProperties;
    private Properties properties = new Properties();


    public Properties getProperties() {
        return properties;
    }

    public static void initProperties() throws IOException {
        if (optiSoinsProperties != null){
            throw new RuntimeException("les propriétés d'optisoin ont dégà été chargé");
        }
        optiSoinsProperties = new OptiSoinsProperties();
        optiSoinsProperties.loadProperties();
    }

    private void loadProperties() throws IOException {
        Path pathProperties = Paths.get(OptiSoinsConfiguration.fichierConfiguration);
        if (Files.isReadable(pathProperties)){
            properties.load(Files.newInputStream(pathProperties));
        }
    }

    public static String getConfiguration(OptiSoinsPropertiesValue optiSoinsPropertiesValue){
        controleInitialisationConfiguration();
        return optiSoinsProperties.getProperties().getProperty(optiSoinsPropertiesValue.getNomConfiguration());
    }

    public static boolean getConfigurationBoolean(OptiSoinsPropertiesValue optiSoinsPropertiesValue){
        return Boolean.valueOf(getConfiguration(optiSoinsPropertiesValue));
    }

    public static int getConfigurationInteger(OptiSoinsPropertiesValue optiSoinsPropertiesValue){
        return Integer.valueOf(getConfiguration(optiSoinsPropertiesValue));
    }

    public static boolean isConfigurationPresente(OptiSoinsPropertiesValue optiSoinsPropertiesValue) {
        controleInitialisationConfiguration();
        return optiSoinsProperties.getProperties().getProperty(optiSoinsPropertiesValue.getNomConfiguration()) != null;
    }

    private static void controleInitialisationConfiguration(){
        if (optiSoinsProperties == null){
            throw new RuntimeException("les propriétés d'optisoin n'ont pas été chargé");
        }
    }
}
