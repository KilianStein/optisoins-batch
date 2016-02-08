package ki.optisoins.export.etat;

import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;

public class EtatJasperMapper {

  public EtatJasper map(Etat etat) {
    EtatJasper etatJasper = new EtatJasper();
    etatJasper.setDate(etat.getDate());
    etatJasper.setTotal(EtatJasperFormat.formatXPF(etat.getMontantTotal()));
    etatJasper.setAbattement(EtatJasperFormat.formatXPF(etat.getAbattement()));
    etatJasper.setMontantDu(EtatJasperFormat.formatXPF(etat.getMontantDu()));
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