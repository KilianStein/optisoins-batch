package ki.optisoins.export.etat;

import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;

public class EtatJasperMapper {

  public EtatJasper map(Etat etat) {
    EtatJasper etatJasper = new EtatJasper();
    etatJasper.setDate(etat.getDate());
    etatJasper.setTotalActesEtDeplacements(EtatJasperFormat.formatXPF(etat.getMontantTotalActesEtDeplacements()));
    etatJasper.setMontantAbattement(EtatJasperFormat.formatXPF(etat.getMontantAbattement()));
    etatJasper.setMontantAPayer(EtatJasperFormat.formatXPF(etat.getMontantAPayer()));
    etatJasper.setNumero(etat.getNumero());
    mapFeuillesSoins(etatJasper, etat);
    return etatJasper;
  }

  private void mapFeuillesSoins(EtatJasper etatJasper, Etat etat) {
    int i = 1;
    for (FeuilleSoins feuilleSoins : etat.getFeuillesSoins()) {
      etatJasper.setFeuilleSoins(i++, EtatJasperFormat.formatFeuilleSoins(feuilleSoins));
    }
  }
}