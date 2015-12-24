package ki.optisoins;

public enum OptiSoinsPropertiesValue {
    UN_DOSSIER_PAR_EXCEL("UN_DOSSIER_PAR_EXCEL", Boolean.class),
    IMPRESSION_MARGE_GAUCHE("IMPRESSION_MARGE_GAUCHE", Integer.class),
    IMPRESSION_MARGE_HAUT("IMPRESSION_MARGE_HAUT", Integer.class),
    LOGGER_LEVEL("LOGGER_LEVEL", String.class);

    private String nomConfiguration;
    private Class classeAttendue;

    OptiSoinsPropertiesValue(String nomConfiguration, Class classeAttendue){
        this.nomConfiguration = nomConfiguration;
        this.classeAttendue = classeAttendue;
    }

    public String getNomConfiguration() {
        return nomConfiguration;
    }

    public Class getClasseAttendue() {
        return classeAttendue;
    }
}
