package ki.optisoins.export.etat.map;

import ki.optisoins.export.etat.EtatJasper;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;

import java.util.ArrayList;
import java.util.List;

public class Etat100JasperMapper extends EtatJasperMapper {

  private static final String FEUILLES_SOINS_ETAT_DEFAULT_FORMAT = " ; ; ; ; ";
  private static final int NOMBRE_LIGNE_FEUILLE_SOINS_MAX = 20;

  @Override
  protected EtatJasper map(Etat etat, EtatJasper etatJasper) {
    etatJasper.setDate(etat.getDate());
    etatJasper.setNumero(etat.getNumero());
    etatJasper.setTotalActesEtDeplacements(formatXPF(etat.getMontantTotalActesEtDeplacements()));
    etatJasper.setMontantAbattement(formatXPF(etat.getMontantAbattement()));
    etatJasper.setMontantAPayer(formatXPF(etat.getMontantAPayer()));
    mapFeuillesSoins(etatJasper, etat);
    return etatJasper;
  }

  private void mapFeuillesSoins(EtatJasper etatJasper, Etat etat) {
    if (etat.getFeuillesSoins().size() > NOMBRE_LIGNE_FEUILLE_SOINS_MAX) {
      throw new RuntimeException("L'état d'Aide Médicale Nord ne peut contenir que 5 actes");
    }

    int i = 1;
    for (FeuilleSoins feuilleSoins : etat.getFeuillesSoins()) {
      etatJasper.setFeuilleSoins(i++, formatFeuilleSoins(feuilleSoins));
    }

    for (; i <= NOMBRE_LIGNE_FEUILLE_SOINS_MAX; i++) {
      etatJasper.setFeuilleSoins(i, FEUILLES_SOINS_ETAT_DEFAULT_FORMAT);
    }
  }

  public static String formatFeuilleSoins(FeuilleSoins feuilleSoins) {
    if (feuilleSoins == null) {
      return FEUILLES_SOINS_ETAT_DEFAULT_FORMAT;
    }
    return String.join(";", getLigne(feuilleSoins));
  }

  private static List<String> getLigne(FeuilleSoins feuilleSoins) {
    List<String> feuillesSoinsEtats = new ArrayList<>();
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(""));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(feuilleSoins.getNumeroCafat()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(feuilleSoins.getNomPrenomMalade()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(feuilleSoins.getNombreActes()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(formatXPF(feuilleSoins.getMontantTotalActes())));
    return feuillesSoinsEtats;
  }
}
