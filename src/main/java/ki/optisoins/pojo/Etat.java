package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class Etat {
  private int numero = 0;
  private String date = "";
  private List<FeuilleSoins> feuillesSoins = new ArrayList<>();

  public int getMontantTotal() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalActes();
    }
    return total;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
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
    feuillesSoins.add(feuilleSoins);
  }

}
