package ki.optisoins.pojo;


public class Assure {
  private String numeroCafat = "";
  private String numeroNCS = "";
  private String nom = "";
  private String prenom = "";
  private String dateNaissance = "";

  private Mutuelle mutuellePrincipale = null;
  private Mutuelle mutuelleComplementaire = null;
  private AideMedicale aideMedicale = null;
  private Adresse adresse = null;

  public String getNumeroCafat() {
    return numeroCafat;
  }

  public void setNumeroCafat(String numeroCafat) {
    this.numeroCafat = numeroCafat;
  }

  public String getNumeroNCS() {
    return numeroNCS;
  }

  public void setNumeroNCS(String numeroNCS) {
    this.numeroNCS = numeroNCS;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(String dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public Mutuelle getMutuellePrincipale() {
    return mutuellePrincipale;
  }

  public void setMutuellePrincipale(Mutuelle mutuellePrincipale) {
    this.mutuellePrincipale = mutuellePrincipale;
  }

  public Mutuelle getMutuelleComplementaire() {
    return mutuelleComplementaire;
  }

  public void setMutuelleComplementaire(Mutuelle mutuelleComplementaire) {
    this.mutuelleComplementaire = mutuelleComplementaire;
  }

  public AideMedicale getAideMedicale() {
    return aideMedicale;
  }

  public void setAideMedicale(AideMedicale aideMedicale) {
    this.aideMedicale = aideMedicale;
  }

  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }
}
