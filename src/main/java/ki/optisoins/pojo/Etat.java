package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class Etat {
  private String numero = "";
  private String date = "";
  private PriseEnCharge priseEnCharge = null;
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

  public int getMontantTotalHonorairesAvecAbattement() {
    return getMontantTotalHonoraires() - getMontantAbattement();
  }

  public int getMontantTotalFraisDeplacements() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalFraisDeplacements();
    }
    return total;
  }

  public int getMontantAbattement() {
    if (PriseEnCharge.isAideMedicaleSud(priseEnCharge)) {
      return (int) Math.ceil((getMontantTotalActesEtDeplacements()) * 0.15);
    } else if (PriseEnCharge.isAideMedicaleNord(priseEnCharge)) {
      return ((int) Math.ceil((getMontantTotalHonoraires()) * 0.15)) + getMontantTotalFraisDeplacements();
    }
    return 0;
  }

  public int getMontantAPayer() {
    if (PriseEnCharge.isRemboursement100Pourcent(priseEnCharge)) {
      return getMontantTotalActesEtDeplacements();
    } else if (PriseEnCharge.isAideMedicale(priseEnCharge)) {
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