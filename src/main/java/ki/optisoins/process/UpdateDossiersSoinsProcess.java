package ki.optisoins.process;

import ki.optisoins.pojo.DossierSoins;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.utils.StringUtils;
import ki.optisoins.utils.UniqueNameUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateDossiersSoinsProcess {

  public List<DossierSoins>  process(List<DossierSoins> dossiersSoins){
    dossiersSoins.forEach(this::process);
    return dossiersSoins;
  }

  private DossierSoins process(DossierSoins dossierSoins) {
    updateFeuillesSoins(dossierSoins);
    generateEtat(dossierSoins);
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


  private void generateEtat(DossierSoins dossierSoins) {
    Map<String, Etat> etats = new HashMap<>();

    for (FeuilleSoins feuilleSoins : dossierSoins.getFeuillesSoins()){
      String dateRecap = feuilleSoins.getAttributsTechnique().getDateRecapitulatif();
      if (StringUtils.isNotEmpty(dateRecap)){
        Etat etat = etats.get(dateRecap);
        if (etat == null){
          etat = new Etat();
          etat.setDate(dateRecap);
          etats.put(dateRecap, etat);
        }
        etat.addFeuillesSoins(feuilleSoins);
      }
    }
    dossierSoins.addAllEtats(etats.values());
  }

}
