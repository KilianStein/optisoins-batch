package ki.optisoins.mapper.xls;

import ki.optisoins.pojo.*;

public class FeuilleSoinsXlsMapper {

  public FeuilleSoins map(FeuilleSoinsXls feuilleSoinsXls) {
    FeuilleSoins feuilleSoins = new FeuilleSoins();
    feuilleSoins.setAssure(mapAssure(feuilleSoinsXls));
    feuilleSoins.setMalade(mapMalade(feuilleSoinsXls));
    feuilleSoins.setOrthophoniste(mapOrthophoniste(feuilleSoinsXls));
    feuilleSoins.setOrdonnanceMedecin(mapOrdonnanceMedecin(feuilleSoinsXls));
    feuilleSoins.setActes(mapActes(feuilleSoinsXls));
    return feuilleSoins;
  }

  private ki.optisoins.mapper.xls.annotations.Assure mapAssure(FeuilleSoinsXls fsXls) {
    return null;
  }

  private Malade mapMalade(FeuilleSoinsXls feuilleSoinsXls) {
    return null;
  }

  private Orthophoniste mapOrthophoniste(FeuilleSoinsXls feuilleSoinsXls) {
    return null;
  }

  private OrdonnanceMedecin mapOrdonnanceMedecin(FeuilleSoinsXls feuilleSoinsXls) {
    return null;
  }

  private Actes mapActes(FeuilleSoinsXls feuilleSoinsXls) {
    return null;
  }
}
