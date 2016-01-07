package ki.optisoins.process;

import ki.optisoins.pojo.DossierSoins;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.utils.UniqueNameUtils;

import java.util.List;

public class UpdateDossiersSoinsProcess {

  public List<DossierSoins>  process(List<DossierSoins> dossiersSoins){
    dossiersSoins.forEach(this::process);
    return dossiersSoins;
  }

  private DossierSoins process(DossierSoins dossierSoins) {
    updateFeuillesSoins(dossierSoins);
    return dossierSoins;
  }

  private DossierSoins updateFeuillesSoins(DossierSoins dossierSoins) {
    for (FeuilleSoins feuilleSoins : dossierSoins.getFeuillesSoins()){
      updateFeuilleSoins(dossierSoins, feuilleSoins);
    }
    return dossierSoins;
  }

  private FeuilleSoins updateFeuilleSoins(DossierSoins dossierSoins, FeuilleSoins feuilleSoins) {
    feuilleSoins.getAttributsTechnique().setName(UniqueNameUtils.generateUniqueName(dossierSoins.getNom(), feuilleSoins.getOrdonnanceMedecin() != null ? feuilleSoins.getOrdonnanceMedecin().getNomEtPrenomMalade() : ""));
    return feuilleSoins;
  }
}
