package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class Etat {
  private String numero = "";
  private String date = "";
  private PriseEnCharge priseEnCharge = null;
  private LocalisationAM localisationAM = null;
  private List<FeuilleSoins> feuillesSoins = new ArrayList<>();

  public int getMontantTotalActesEtDeplacements() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalActes();
    }
    return total;
  }

  public int getMontantTotalHonoraires() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalHonoraires();
    }
    return total;
  }

  public int getMontantTotalFraisDeplacements() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalFraisDeplacements();
    }
    return total;
  }

  public int getMontantAbattement() {
    if (LocalisationAM.SUD.equals(localisationAM)) {
      return (int) Math.ceil((getMontantTotalActesEtDeplacements()) * 0.15);
    } else if (LocalisationAM.NORD.equals(localisationAM)) {
      return ((int) Math.ceil((getMontantTotalHonoraires()) * 0.15)) + getMontantTotalFraisDeplacements();
    }
    return 0;
  }

  public int getMontantAPayer() {
    if (PriseEnCharge.REMBOURSEMENT_100_POURCENT.equals(priseEnCharge)) {
      return getMontantTotalActesEtDeplacements();
    } else if (PriseEnCharge.AIDE_MEDICALE.equals(priseEnCharge)) {
      return getMontantTotalActesEtDeplacements() - getMontantAbattement();
    }
    return 0;
  }

  public PriseEnCharge getPriseEnCharge() {
    return priseEnCharge;
  }

  public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
    this.priseEnCharge = priseEnCharge;
  }

  public LocalisationAM getLocalisationAM() {
    return localisationAM;
  }

  public void setLocalisationAM(LocalisationAM localisationAM) {
    this.localisationAM = localisationAM;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public List<FeuilleSoins> getFeuillesSoins() {
    return feuillesSoins;
  }

  public void addFeuillesSoins(FeuilleSoins feuilleSoins) {
    if (feuillesSoins.size() >= 20) {
      throw new RuntimeException("Plus de 20 feuilles de soins ont été ajoutés à l'état numéro " + getNumero() + " alors que le maximun autorisé est de 20");
    }
    feuillesSoins.add(feuilleSoins);
  }

}
