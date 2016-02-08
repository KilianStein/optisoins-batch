package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class Etat {
  private String numero = "";
  private String date = "";
  private PriseEnCharge priseEnCharge = null;
  private LocalisationAM localisationAM = null;
  private List<FeuilleSoins> feuillesSoins = new ArrayList<>();

  public int getMontantTotal() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalActes();
    }
    return total;
  }

  public int getAbattement() {
    return (int)Math.ceil((getMontantTotal()) *  0.15);
  }

  public int getMontantDu() {
    return getMontantTotal() - getAbattement();
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
