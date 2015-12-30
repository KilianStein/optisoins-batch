package ki.optisoins.pojo;

public class Orthophoniste {
  private String nomEtPrenom = "";
  private String identification = "";
  private CompteBancaire banque = null;

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

  public CompteBancaire getBanque() {
    return banque;
  }

  public void setBanque(CompteBancaire banque) {
    this.banque = banque;
  }
}
