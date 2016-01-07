package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class Etat {
  private String numero = "";
  private String date = "";
  private List<FeuilleSoins> feuillesSoins = new ArrayList<>();

  public int getMontantTotal() {
    int total = 0;
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      total += feuilleSoins.getMontantTotalActes();
    }
    return total;
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
    if (feuillesSoins.size() >= 20){
      throw new RuntimeException("Plus de 20 feuilles de soins ont été ajoutés à l'état numéro " + getNumero() + " alors que le maximun autorisé est de 20"  );
    }
    feuillesSoins.add(feuilleSoins);
  }

}
