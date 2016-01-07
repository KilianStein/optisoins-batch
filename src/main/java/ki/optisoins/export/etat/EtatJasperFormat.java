package ki.optisoins.export.etat;

import ki.optisoins.pojo.FeuilleSoins;

import java.util.ArrayList;
import java.util.List;

public class EtatJasperFormat {

  public static final String FEUILLE_SOINS_DEFAULT_FORMAT = " ; ; ; ; ";

  public static String formatFeuilleSoins(FeuilleSoins feuilleSoins) {
    if (feuilleSoins == null) {
      return FEUILLE_SOINS_DEFAULT_FORMAT;
    }
    List<String> acteListe = new ArrayList<>();
    acteListe.add(" ");
    acteListe.add(formatFeuilleSoinsAttribute(feuilleSoins.getNumeroCafat()));
    acteListe.add(formatFeuilleSoinsAttribute(feuilleSoins.getNomPrenomMalade()));
    acteListe.add(formatFeuilleSoinsAttribute(feuilleSoins.getNombreActes()));
    acteListe.add(formatFeuilleSoinsAttribute(formatXPF(feuilleSoins.getMontantTotalActes())));
    return String.join(";", acteListe);
  }

  private static String formatFeuilleSoinsAttribute(String s) {
    return s == null || "".equals(s) ? " " : s;
  }

  private static String formatFeuilleSoinsAttribute(int i) {
    return i == 0 ? " " : String.valueOf(i);
  }
  
  public static String formatXPF(int montant) {
    return montant == 0 ? "" : String.valueOf(montant) + " XPF";
  }
}
