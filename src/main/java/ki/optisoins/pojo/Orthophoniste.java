package ki.optisoins.pojo;

public class Orthophoniste {
  private String nomEtPrenom = "";
  private String adresse = "";
  private String numeroCafat = "";
  private String numeroRidet = "";
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

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getNumeroCafat() {
    return numeroCafat;
  }

  public void setNumeroCafat(String numeroCafat) {
    this.numeroCafat = numeroCafat;
  }

  public String getNumeroRidet() {
    return numeroRidet;
  }

  public void setNumeroRidet(String numeroRidet) {
    this.numeroRidet = numeroRidet;
  }
}
