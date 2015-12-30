package ki.optisoins.pojo;

public class FeuilleSoins {
  private Assure assure = null;
  private Malade malade = null;
  private Orthophoniste orthophoniste = null;
  private OrdonnanceMedecin ordonnanceMedecin = null;
  private Actes actes = null;

  public boolean isDomicile(){
    return getAssure() != null  && getAssure().getAdresse() != null;
  }

  public Assure getAssure() {
    return assure;
  }

  public void setAssure(Assure assure) {
    this.assure = assure;
  }

  public Malade getMalade() {
    return malade;
  }

  public void setMalade(Malade malade) {
    this.malade = malade;
  }

  public Orthophoniste getOrthophoniste() {
    return orthophoniste;
  }

  public void setOrthophoniste(Orthophoniste orthophoniste) {
    this.orthophoniste = orthophoniste;
  }

  public OrdonnanceMedecin getOrdonnanceMedecin() {
    return ordonnanceMedecin;
  }

  public void setOrdonnanceMedecin(OrdonnanceMedecin ordonnanceMedecin) {
    this.ordonnanceMedecin = ordonnanceMedecin;
  }

  public Actes getActes() {
    return actes;
  }

  public void setActes(Actes actes) {
    this.actes = actes;
  }
}
