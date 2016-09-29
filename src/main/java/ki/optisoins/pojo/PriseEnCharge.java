package ki.optisoins.pojo;

public enum PriseEnCharge {
  REMBOURSEMENT_50_POURCENT,
  REMBOURSEMENT_100_POURCENT,
  AIDE_MEDICALE_SUD,
  AIDE_MEDICALE_NORD,
  AIDE_MEDICALE_ILES;

  public String getAcronyme() {
    switch (this) {
    case REMBOURSEMENT_100_POURCENT:
      return "100";
    case AIDE_MEDICALE_SUD:
      return "AM_Sud";
    case AIDE_MEDICALE_NORD:
      return "AM_Nord";
    case AIDE_MEDICALE_ILES:
      return "AM_Iles";
    default:
      throw new RuntimeException("l'acronyme non géré : " + this);
    }
  }

  public static PriseEnCharge getPriseEnCharge(String priseEnCharge) {
    switch (priseEnCharge.trim().toLowerCase()) {
      case "50%":
        return REMBOURSEMENT_50_POURCENT;
      case "100%":
        return REMBOURSEMENT_100_POURCENT;
      case "aide médicale sud":
        return AIDE_MEDICALE_SUD;
      case "aide médicale nord":
        return AIDE_MEDICALE_NORD;
      case "aide médicale iles":
        return AIDE_MEDICALE_ILES;
      default:
        throw new RuntimeException("la prise en charge " + priseEnCharge + " n'est pas reconnue, les valeurs possibles sont '50%', '100%', 'aide médicale'");
    }
  }

  public static boolean isAideMedicale(PriseEnCharge priseEnCharge) {
    return isAideMedicaleNord(priseEnCharge) || isAideMedicaleSud(priseEnCharge);
  }

  public static boolean isAideMedicaleIles(PriseEnCharge priseEnCharge) {
    return AIDE_MEDICALE_ILES.equals(priseEnCharge);
  }

  public static boolean isAideMedicaleNord(PriseEnCharge priseEnCharge) {
    return AIDE_MEDICALE_NORD.equals(priseEnCharge);
  }

  public static boolean isAideMedicaleSud(PriseEnCharge priseEnCharge) {
    return AIDE_MEDICALE_SUD.equals(priseEnCharge);
  }

  public static boolean isRemboursement100Pourcent(PriseEnCharge priseEnCharge) {
    return REMBOURSEMENT_100_POURCENT.equals(priseEnCharge);
  }

  public static boolean isRemboursement50Pourcent(PriseEnCharge priseEnCharge) {
    return REMBOURSEMENT_50_POURCENT.equals(priseEnCharge);
  }
}