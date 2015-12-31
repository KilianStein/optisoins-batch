package ki.optisoins.pojo;

import ki.optisoins.utils.StringUtils;

public enum SituationMalade {
  SALARIE("salarie"),
  TRAVAILLEUR_INDEPENDANT("travailleur independant"),
  FONCTIONNAIRE("fonctionnaire"),
  RETRAITE("retraite"),
  SCOLAIRE("scolaire"),
  INACTIF("inactif"),
  TOUS("tous");

  private String value;

  SituationMalade(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static SituationMalade get(String situationMalade) {
    if (StringUtils.isNotEmpty(situationMalade)) {
      switch (situationMalade.toLowerCase().replace("é", "e")) {
        case "salarie":
          return SALARIE;
        case "travailleur independant":
        case "travailleur":
        case "independant":
          return TRAVAILLEUR_INDEPENDANT;
        case "fonctionnaire":
          return FONCTIONNAIRE;
        case "retraite":
          return RETRAITE;
        case "scolaire":
          return SCOLAIRE;
        case "inactif":
          return INACTIF;
        case "tous":
          return TOUS;
        default:
          throw new RuntimeException("la situation du malade '" + situationMalade + "' n'est pas reconnu");
      }
    }
    return null;
  }
}
