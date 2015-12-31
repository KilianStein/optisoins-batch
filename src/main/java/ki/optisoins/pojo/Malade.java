package ki.optisoins.pojo;

public class Malade {

  private String nom = "";
  private String prenom = "";
  private String dateNaissance = "";
  private LienAssure lienAvecAssure = null;
  private String employeur = "";
  private String situationMalade = "";
  private String numeroNCS = "";

  private Accident accident = null;

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

  public LienAssure getLienAvecAssure() {
    return lienAvecAssure;
  }

  public void setLienAvecAssure(LienAssure lienAvecAssure) {
    this.lienAvecAssure = lienAvecAssure;
  }

  public String getEmployeur() {
    return employeur;
  }

  public void setEmployeur(String employeur) {
    this.employeur = employeur;
  }

  public String getSituationMalade() {
    return situationMalade;
  }

  public void setSituationMalade(String situationMalade) {
    this.situationMalade = situationMalade;
  }

  public String getNumeroNCS() {
    return numeroNCS;
  }

  public void setNumeroNCS(String numeroNCS) {
    this.numeroNCS = numeroNCS;
  }

  public Accident getAccident() {
    return accident;
  }

  public void setAccident(Accident accident) {
    this.accident = accident;
  }
}
