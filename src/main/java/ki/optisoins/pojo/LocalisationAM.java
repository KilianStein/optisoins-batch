package ki.optisoins.pojo;

import ki.optisoins.utils.StringUtils;

public enum LocalisationAM {
  SUD,
  NORD;

  public static LocalisationAM getLocalisationAM(String localisationAM) {
    if (StringUtils.isEmpty(localisationAM)){
      return null;
    }
    switch (localisationAM.trim().toLowerCase()) {
      case "sud":
        return SUD;
      case "nord":
        return NORD;
      default:
        throw new RuntimeException("La localisation d'aide médicale " + localisationAM + " n'est pas reconnue, les valeurs possibles sont 'SUD', 'NORD'");
    }
  }
}