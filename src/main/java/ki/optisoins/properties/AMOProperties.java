package ki.optisoins.properties;

import ki.optisoins.OptiSoinsConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class AMOProperties {
    private static AMOProperties amoProperties;
    private Properties properties = new Properties();


    public Properties getProperties() {
        return properties;
    }

    public static void initProperties() throws IOException {
        if (amoProperties != null){
            throw new RuntimeException("les propriétés d'optisoin ont dégà été chargé");
        }
        amoProperties = new AMOProperties();
        amoProperties.loadProperties();
    }

    private void loadProperties() throws IOException {
        Path pathProperties = Paths.get(OptiSoinsConfiguration.amoConfiguration);
        if (Files.isReadable(pathProperties)){
            properties.load(Files.newInputStream(pathProperties));
        }
    }

    public static int getAMOValue(String amo){
        if (amo == null || "".equals(amo)){
            return 0;
        }
        controleInitialisationConfiguration();
        String amoValue = amoProperties.getProperties().getProperty(amo);
        if (amoValue == null){
            throw new RuntimeException("l'AMO " + amo + " n'a pas été défini dans le fichier de configuration");
        }
        return Integer.parseInt(amoValue);
    }

    private static void controleInitialisationConfiguration(){
        if (amoProperties == null){
            throw new RuntimeException("les propriétés d'optisoin n'ont pas été chargé");
        }
    }
}
