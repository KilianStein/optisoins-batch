package ki.optisoins.export.etat.map;

import ki.optisoins.export.etat.EtatJasper;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.PriseEnCharge;

public abstract class EtatJasperMapper {

  private static EtatJasperMapper getInstance(Etat etat) {
    if (PriseEnCharge.isRemboursement100Pourcent(etat.getPriseEnCharge())) {
      return new Etat100JasperMapper();
    } else if (PriseEnCharge.isAideMedicaleSud(etat.getPriseEnCharge())) {
      return new EtatSudJasperMapper();
    } else if (PriseEnCharge.isAideMedicaleNord(etat.getPriseEnCharge())) {
      return new EtatNordJasperMapper();
    } else if (PriseEnCharge.isAideMedicaleIles(etat.getPriseEnCharge())) {
      return new EtatIlesJasperMapper();
    }
    throw new RuntimeException("Etat " + etat.getNumero() + " non géré.");
  }

  public static EtatJasper map(Etat etat) {
    return getInstance(etat).map(etat, new EtatJasper());
  }

  protected abstract EtatJasper map(Etat etat, EtatJasper etatJasper);

  protected static String formatFeuilleSoinsAttribute(String s) {
    return s == null || "".equals(s) ? " " : s;
  }

  protected static String formatFeuilleSoinsAttribute(int i) {
    return i == 0 ? " " : String.valueOf(i);
  }

  protected static String formatXPF(int montant) {
    return montant == 0 ? "" : String.valueOf(montant) + " XPF";
  }

  protected static String formatXPFAvecZero(int montant) {
    return String.valueOf(montant) + " XPF";
  }
}