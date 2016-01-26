package ki.optisoins.pojo;

public class FeuilleSoins {

  private String numeroEtat = "";
  private PriseEnCharge priseEnCharge = null;
  private AttributsTechnique attributsTechnique = null;
  private Assure assure = null;
  private Malade malade = null;
  private Orthophoniste orthophoniste = null;
  private OrdonnanceMedecin ordonnanceMedecin = null;
  private Actes actes = null;

  public boolean isDomicile() {
    return getAssure() != null && getAssure().getAdresse() != null;
  }

  public String getNumeroCafat() {
    return assure != null ? assure.getNumeroCafat() : "";
  }

  public String getNomPrenomMalade() {
    return ordonnanceMedecin != null ? ordonnanceMedecin.getNomEtPrenomMalade() : "";
  }

  public int getNombreActes() {
    return actes != null ? actes.getNombreActes() : 0;
  }

  public int getMontantTotalActes() {
    return actes != null ? actes.getMontantTotal() : 0;
  }

  public PriseEnCharge getPriseEnCharge() {
    return priseEnCharge;
  }

  public void setPriseEnCharge(PriseEnCharge priseEnCharge) {
    this.priseEnCharge = priseEnCharge;
  }

  public String getNumeroEtat() {
    return numeroEtat;
  }

  public void setNumeroEtat(String numeroEtat) {
    this.numeroEtat = numeroEtat;
  }

  public AttributsTechnique getAttributsTechnique() {
    return attributsTechnique;
  }

  public void setAttributsTechnique(AttributsTechnique attributsTechnique) {
    this.attributsTechnique = attributsTechnique;
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
