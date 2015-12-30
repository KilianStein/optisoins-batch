package ki.optisoins.pojo;

public class Adresse {
  private String appartement = "";
  private String batiment = "";
  private String rue = "";
  private String codePostal = "";
  private String boitePostale = "";
  private String commune = "";

  public String getAppartement() {
    return appartement;
  }

  public void setAppartement(String appartement) {
    this.appartement = appartement;
  }

  public String getBatiment() {
    return batiment;
  }

  public void setBatiment(String batiment) {
    this.batiment = batiment;
  }

  public String getRue() {
    return rue;
  }

  public void setRue(String rue) {
    this.rue = rue;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public String getBoitePostale() {
    return boitePostale;
  }

  public void setBoitePostale(String boitePostale) {
    this.boitePostale = boitePostale;
  }

  public String getCommune() {
    return commune;
  }

  public void setCommune(String commune) {
    this.commune = commune;
  }
}
