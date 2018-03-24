package ki.optisoins.export.etat.map;

import ki.optisoins.export.etat.EtatJasper;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.Orthophoniste;

public class EtatSudJasperMapper extends Etat100JasperMapper {

  @Override
  protected EtatJasper map(Etat etat, EtatJasper etatJasper) {
    super.map(etat, etatJasper);
    Orthophoniste orthophoniste = etat.getFeuillesSoins().get(0).getOrthophoniste();
    etatJasper.setNomOrthophoniste(orthophoniste.getNomEtPrenom());
    etatJasper.setNumeroCompteOrthophoniste(orthophoniste.getCompteBancaire().getNumeroCompte());
    etatJasper.setNomBanqueOrthophoniste(orthophoniste.getCompteBancaire().getNomBanque());
    etatJasper.setNumeroRidetOrthophoniste(orthophoniste.getNumeroRidet());
    etatJasper.setNumeroCafatOrthophoniste(orthophoniste.getNumeroCafat());
    etatJasper.setTotalActesEtDeplacements(formatXPF(etat.getMontantTotalActesEtDeplacements()));
    etatJasper.setMontantAbattement(formatXPF(etat.getMontantAbattement()));
    return etatJasper;
  }
}
