package ki.optisoins.jasper;

import ki.optisoins.pojo.Acte;

import java.util.ArrayList;
import java.util.List;

public class FeuilleSoinsJasperFormat {

  public static final String ACTE_DEFAULT_FORMAT = " ; ; ; ; ; ; ; ; ";

  public static String formatActe(Acte acte) {
    if (acte == null) {
      return ACTE_DEFAULT_FORMAT;
    }
    List<String> acteListe = new ArrayList<>();
    acteListe.add(formatActeAttribute(acte.getDate()));
    acteListe.add(formatActeAttribute(acte.getOrigine()));
    acteListe.add(formatActeAMO(acte.getAmo()));
    acteListe.add(formatActeAttribute(acte.getMontantHonoraire()));
    acteListe.add(formatActeAttribute(acte.getFraisDeplacement()));
    acteListe.add(" ");
    acteListe.add(" ");
    acteListe.add(formatActeAttribute(acte.getTicketModerateur()));
    acteListe.add(formatActeAttribute(acte.getTotal()));
    return String.join(";", acteListe);
  }

  private static String formatActeAMO(String s) {
    return s == null || "".equals(s) ? " " : "AMO " + s;
  }

  private static String formatActeAttribute(String s) {
    return s == null || "".equals(s) ? " " : s;
  }

  private static String formatActeAttribute(int i) {
    return i == 0 ? " " : String.valueOf(i);
  }

  public static String formatNumeroCompte(String numeroCompte) {
    return splitSpace(numeroCompte, " ");
  }

  public static String formatAssureNumeroCafat(String numeroCafat) {
    return splitSpace(numeroCafat, "  ");
  }

  private static String splitSpace(String s, String space) {
    return s.trim().replace(" ", "").replace("", space).trim();
  }
}
