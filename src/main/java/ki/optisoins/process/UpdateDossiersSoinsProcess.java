package ki.optisoins.process;

import ki.optisoins.pojo.DossierSoins;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.utils.StringUtils;
import ki.optisoins.utils.UniqueNameUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateDossiersSoinsProcess {

  public List<DossierSoins> process(List<DossierSoins> dossiersSoins) {
    dossiersSoins.forEach(this::process);
    return dossiersSoins;
  }

  private DossierSoins process(DossierSoins dossierSoins) {
    updateFeuillesSoins(dossierSoins);
    generateEtat(dossierSoins);
    return dossierSoins;
  }

  private DossierSoins updateFeuillesSoins(DossierSoins dossierSoins) {
    for (FeuilleSoins feuilleSoins : dossierSoins.getFeuillesSoins()) {
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

    for (FeuilleSoins feuilleSoins : dossierSoins.getFeuillesSoins()) {
      String numeroEtat = feuilleSoins.getNumeroEtat();
      if (StringUtils.isNotEmpty(numeroEtat)) {
        Etat etat = etats.get(numeroEtat);
        if (etat == null) {
          etat = createEtat(feuilleSoins);
          etats.put(numeroEtat, etat);
        } else {
          validateEtat(etat, feuilleSoins);
        }
        etat.addFeuillesSoins(feuilleSoins);
      }
    }
    dossierSoins.addAllEtats(etats.values());
  }

  private void validateEtat(Etat etat, FeuilleSoins feuilleSoins) {
    if (etat.getPriseEnCharge() != null && !etat.getPriseEnCharge().equals(feuilleSoins.getPriseEnCharge())) {
      throw new RuntimeException("Le même numéro d'état '" + etat.getNumero() + "' est utilisé pour des prises en charges differentes ");
    }
  }

  private Etat createEtat(FeuilleSoins feuilleSoins) {
    Etat etat = new Etat();
    etat.setNumero(feuilleSoins.getNumeroEtat());
    etat.setPriseEnCharge(feuilleSoins.getPriseEnCharge());
    etat.setDate(Instant.now().atZone(ZoneId.of("GMT+11")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    return etat;
  }
}
