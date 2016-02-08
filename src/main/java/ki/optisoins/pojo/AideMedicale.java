package ki.optisoins.pojo;

public class AideMedicale {
  private LocalisationAM localisationAM = null;
  private String dateDebutValidite = "";
  private String dateFinValidite = "";
  private String numero = "";

  public LocalisationAM getLocalisationAM() {
    return localisationAM;
  }

  public void setLocalisationAM(LocalisationAM localisationAM) {
    this.localisationAM = localisationAM;
  }

  public String getDateDebutValidite() {
    return dateDebutValidite;
  }

  public void setDateDebutValidite(String dateDebutValidite) {
    this.dateDebutValidite = dateDebutValidite;
  }

  public String getDateFinValidite() {
    return dateFinValidite;
  }

  public void setDateFinValidite(String dateFinValidite) {
    this.dateFinValidite = dateFinValidite;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }
}
