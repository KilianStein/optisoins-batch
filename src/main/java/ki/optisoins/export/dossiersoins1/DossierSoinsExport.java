package ki.optisoins.export.dossiersoins1;

import ki.optisoins.export.etat.EtatExport;
import ki.optisoins.export.feuillesoins1.FeuilleSoinsExport;
import ki.optisoins.pojo.DossierSoins;

import java.util.List;

public class DossierSoinsExport {

  public static void exportPDF(List<DossierSoins> dossiersSoins) {
    dossiersSoins.forEach(DossierSoinsExport::exportPDF);
  }

  private static void exportPDF(DossierSoins dossierSoins) {
    FeuilleSoinsExport.exportPDF(dossierSoins.getFeuillesSoins(), dossierSoins.getNom());
    EtatExport.exportPDF(dossierSoins.getFeuillesSoins(), dossierSoins.getNom());
  }
}
