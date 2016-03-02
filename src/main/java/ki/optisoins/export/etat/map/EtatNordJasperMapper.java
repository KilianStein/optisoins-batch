package ki.optisoins.export.etat.map;

import ki.optisoins.export.etat.EtatJasper;
import ki.optisoins.pojo.Acte;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.pojo.Orthophoniste;
import ki.optisoins.utils.NumberToWordsUtils;

import java.util.ArrayList;
import java.util.List;

public class EtatNordJasperMapper extends EtatJasperMapper {

  private static final String FEUILLES_SOINS_ETAT_NORD_DEFAULT_FORMAT = " ; ; ; ; ; ; ; ; ; ";
  private static final int NOMBRE_LIGNE_ACTE_MAX = 5;

  @Override
  protected EtatJasper map(Etat etat, EtatJasper etatJasper) {
    etatJasper.setDate(etat.getDate());
    etatJasper.setNumero(etat.getNumero());
    Orthophoniste orthophoniste = etat.getFeuillesSoins().get(0).getOrthophoniste();
    etatJasper.setNomOrthophoniste(orthophoniste.getNomEtPrenom());
    etatJasper.setAdresseOrthophoniste(orthophoniste.getAdresse());
    etatJasper.setNumeroCompteOrthophoniste(orthophoniste.getCompteBancaire().getNumeroCompte());
    etatJasper.setNumeroRidetOrthophoniste(orthophoniste.getNumeroRidet());
    etatJasper.setNumeroCafatOrthophoniste(orthophoniste.getNumeroCafat());
    etatJasper.setTotalActes(formatXPF(etat.getMontantTotalHonoraires()));
    etatJasper.setMontantAbattement(formatXPF(etat.getMontantAbattement()));
    etatJasper.setTotalDeplacement(formatXPFAvecZero(etat.getMontantTotalFraisDeplacements()));
    etatJasper.setTotalActesAvecAbattement(formatXPF(etat.getMontantTotalHonorairesAvecAbattement()));
    etatJasper.setMontantAPayer(formatXPF(etat.getMontantAPayer()));
    etatJasper.setMontantAPayerLettres(NumberToWordsUtils.convert(etat.getMontantAPayer()).toUpperCase() + " XPF");
    mapActes(etatJasper, etat);
    return etatJasper;
  }

  private void mapActes(EtatJasper etatJasper, Etat etat) {
    if (getNombreActes(etat) > NOMBRE_LIGNE_ACTE_MAX) {
      throw new RuntimeException("L'état d'Aide Médicale Nord ne peut contenir que 5 actes");
    }
    int i = 1;
    for (FeuilleSoins feuilleSoins : etat.getFeuillesSoins()) {
      for (Acte acte : feuilleSoins.getActes().getActes()) {
        etatJasper.setFeuilleSoins(i++, formatActe(feuilleSoins, acte));
      }
    }
    for (; i <= NOMBRE_LIGNE_ACTE_MAX; i++) {
      etatJasper.setFeuilleSoins(i, FEUILLES_SOINS_ETAT_NORD_DEFAULT_FORMAT);
    }
  }

  public int getNombreActes(Etat etat) {
    int i = 0;
    for (FeuilleSoins feuilleSoins : etat.getFeuillesSoins()) {
      for (Acte acte : feuilleSoins.getActes().getActes()) {
        i++;
      }
    }
    return i;
  }

  public static String formatActe(FeuilleSoins feuilleSoins, Acte acte) {
    if (feuilleSoins == null) {
      return FEUILLES_SOINS_ETAT_NORD_DEFAULT_FORMAT;
    }
    return String.join(";", formatActes(feuilleSoins, acte));
  }

  private static List<String> formatActes(FeuilleSoins feuilleSoins, Acte acte) {
    List<String> feuillesSoinsEtats = new ArrayList<>();
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(feuilleSoins.getAssure().getAideMedicale().getNumero()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(feuilleSoins.getAssure().getNom()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(feuilleSoins.getOrdonnanceMedecin().getNumeroACP()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(acte.getDate()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(acte.getAmo()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(""));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(acte.getMontantHonoraire()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(acte.isDomicile() ? "1" : ""));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(acte.getFraisDeplacement()));
    feuillesSoinsEtats.add(formatFeuilleSoinsAttribute(acte.getFraisDeplacement()));
    return feuillesSoinsEtats;
  }
}
