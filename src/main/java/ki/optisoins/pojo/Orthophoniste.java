package ki.optisoins.pojo;

public class Orthophoniste {
  private String nomEtPrenom = "";
  private String identification = "";
  private CompteBancaire compteBancaire = null;

  public String getNomEtPrenom() {
    return nomEtPrenom;
  }

  public void setNomEtPrenom(String nomEtPrenom) {
    this.nomEtPrenom = nomEtPrenom;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public CompteBancaire getCompteBancaire() {
    return compteBancaire;
  }

  public void setCompteBancaire(CompteBancaire compteBancaire) {
    this.compteBancaire = compteBancaire;
  }
}
