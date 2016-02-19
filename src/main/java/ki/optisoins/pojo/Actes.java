package ki.optisoins.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Représente les actes d'une feuille de soin.
 */
public class Actes {

  public static final int NOMBRE_ACTES_MAX_PAR_FEUILLE_DE_SOINS = 11;

  private List<Acte> actes = new ArrayList<>(NOMBRE_ACTES_MAX_PAR_FEUILLE_DE_SOINS - 1);

  public Actes() {
    for (int i = 0; i < NOMBRE_ACTES_MAX_PAR_FEUILLE_DE_SOINS; i++) {
      actes.add(null);
    }
  }

  public List<Acte> getActes() {
    return actes.stream().filter(a -> a != null).collect(Collectors.toList());
  }

  public int getMontantTotal() {
    return getActes().stream().mapToInt(Acte::getTotal).sum();
  }

  public int getMontantTotalHonoraires() {
    return getActes().stream().mapToInt(Acte::getMontantHonoraire).sum();
  }

  public int getMontantTotalFraisDeplacements() {
    return getActes().stream().mapToInt(Acte::getFraisDeplacement).sum();
  }

  public void setToActes(int numeroLigne, Acte acte) {
    actes.set(numeroLigne - 1, acte);
  }

  public Acte getActe(int numeroLigne) {
    return actes.get(numeroLigne - 1);
  }

  public int getNombreActes() {
    return getActes().size();
  }
}
