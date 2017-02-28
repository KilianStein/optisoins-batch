package ki.optisoins.properties;

public enum ConfigurationPropertiesValue {
  IDENTIFIANT_FEUILLE_SOINS("IDENTIFIANT_FEUILLE_SOINS", String.class),
  IMPRESSION_MARGE_GAUCHE("IMPRESSION_MARGE_GAUCHE", Integer.class),
  IMPRESSION_MARGE_HAUT("IMPRESSION_MARGE_HAUT", Integer.class),
  LOGGER_LEVEL("LOGGER_LEVEL", String.class),
  AFFICHER_FOND("AFFICHER_FOND", String.class),
  AFFICHER_BORDURES("AFFICHER_BORDURES", String.class);

  private String nomConfiguration;
  private Class classeAttendue;

  ConfigurationPropertiesValue(String nomConfiguration, Class classeAttendue) {
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
