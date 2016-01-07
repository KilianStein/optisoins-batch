package ki.optisoins.export.etat;

import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;

import java.util.List;
import java.util.stream.Collectors;

public class EtatJasperMapper {

  public List<EtatJasper> map(List<Etat> etats) {
    return etats.stream().map(this::map).collect(Collectors.toList());
  }

  private EtatJasper map(Etat etat) {
    EtatJasper etatJasper = new EtatJasper();
    etatJasper.setDate(etat.getDate());
    etatJasper.setTotal(EtatJasperFormat.format(etat.getMontantTotal()));
    etatJasper.setNumero(EtatJasperFormat.format(etat.getNumero()));
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
