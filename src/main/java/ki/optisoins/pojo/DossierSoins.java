package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DossierSoins {

  private String nom = "";
  private List<FeuilleSoins> feuillesSoins = new ArrayList<>();
  private List<Etat> etats = new ArrayList<>();

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public List<FeuilleSoins> getFeuillesSoins() {
    return feuillesSoins;
  }

  public void addFeuillesSoins(FeuilleSoins feuilleSoins) {
    feuillesSoins.add(feuilleSoins);
  }

  public List<Etat> getEtats() {
    return etats;
  }

  public void addAllEtats(Collection<Etat> etats) {
    this.etats.addAll(etats);
  }
}
