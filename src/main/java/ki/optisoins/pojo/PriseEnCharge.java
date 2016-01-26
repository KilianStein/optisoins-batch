package ki.optisoins.pojo;

public enum PriseEnCharge {
  REMBOURSEMENT_50_POURCENT,
  REMBOURSEMENT_100_POURCENT,
  AIDE_MEDICALE;

  public static PriseEnCharge getPriseEnCharge(String priseEnCharge) {
    switch (priseEnCharge.trim().toLowerCase()) {
      case "50%":
        return REMBOURSEMENT_50_POURCENT;
      case "100%":
        return REMBOURSEMENT_100_POURCENT;
      case "aide médicale":
        return AIDE_MEDICALE;
      default:
        throw new RuntimeException("la prise en charge " + priseEnCharge + " n'est pas reconnue, les valeurs possibles sont '50%', '100%', 'aide médicale'");
    }
  }
}