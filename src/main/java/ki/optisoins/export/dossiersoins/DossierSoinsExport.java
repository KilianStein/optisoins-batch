package ki.optisoins.export.dossiersoins;

import ki.optisoins.export.etat.EtatExport;
import ki.optisoins.export.feuillesoins.FeuilleSoinsExport;
import ki.optisoins.pojo.DossierSoins;

import java.util.List;

public class DossierSoinsExport {

  public static void exportPDF(List<DossierSoins> dossiersSoins) {
    dossiersSoins.forEach(DossierSoinsExport::exportPDF);
  }

  private static void exportPDF(DossierSoins dossierSoins) {
    FeuilleSoinsExport.exportPDF(dossierSoins.getFeuillesSoins(), dossierSoins.getNom());
    EtatExport.exportPDF(dossierSoins.getEtats(), dossierSoins.getNom());
  }
}
