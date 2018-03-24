package ki.optisoins.export.etat.map;

import ki.optisoins.export.etat.EtatJasper;
import ki.optisoins.pojo.Etat;

public class EtatIlesJasperMapper extends Etat100JasperMapper {

  @Override
  protected EtatJasper map(Etat etat, EtatJasper etatJasper) {
    super.map(etat, etatJasper);
    etatJasper.setTotalActesEtDeplacements(formatXPF(etat.getMontantTotalActesEtDeplacements()));
    etatJasper.setMontantAbattement(formatXPF(etat.getMontantAbattement()));
    return etatJasper;
  }
}
