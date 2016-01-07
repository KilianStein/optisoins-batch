package ki.optisoins.bdd.xls;

import ki.optisoins.pojo.DossierSoins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DossierSoinsXlsMapper {

  public List<DossierSoins> map(List<FeuilleSoinsXls> feuillesSoinsXls) {
    Map<String, DossierSoins> dossiersSoins = new HashMap<>();
    for (FeuilleSoinsXls feuilleSoinsXls : feuillesSoinsXls) {
      DossierSoins dossierSoins = dossiersSoins.get(feuilleSoinsXls.getNomFichier());
      if (dossierSoins == null) {
        dossierSoins = new DossierSoins();
        dossiersSoins.put(feuilleSoinsXls.getNomFichier(), dossierSoins);
      }
      dossierSoins.setNom(feuilleSoinsXls.getNomFichier().replace(FeuilleSoinsXlsExtract.XLS_EXTENSION, ""));
      dossierSoins.addFeuillesSoins(new FeuilleSoinsXlsMapper().map(feuilleSoinsXls));
    }
    return new ArrayList<>(dossiersSoins.values());
  }
}
