package ki.optisoins.export.DossierSoins;

import ki.optisoins.export.FeuilleSoins.FeuilleSoinsExport;
import ki.optisoins.pojo.DossierSoins;

import java.util.List;

public class DossierSoinsExport {

  public static void exportPDF(List<DossierSoins> dossiersSoins) {
    dossiersSoins.forEach(DossierSoinsExport::exportPDF);
  }

  private static void exportPDF(DossierSoins dossierSoins) {
    FeuilleSoinsExport.exportPDF(dossierSoins.getFeuillesSoins(), dossierSoins.getNom());
  }
}
