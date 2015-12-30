package ki.optisoins.pojo;

public class OrdonnanceMedecin {
  private String datePrescription = "";
  private String nomMedecin = "";
  private String identifiantMedecin = "";
  private String numeroACP = "";
  private String nomEtPrenomMalade = "";

  public String getDatePrescription() {
    return datePrescription;
  }

  public void setDatePrescription(String datePrescription) {
    this.datePrescription = datePrescription;
  }

  public String getNomMedecin() {
    return nomMedecin;
  }

  public void setNomMedecin(String nomMedecin) {
    this.nomMedecin = nomMedecin;
  }

  public String getIdentifiantMedecin() {
    return identifiantMedecin;
  }

  public void setIdentifiantMedecin(String identifiantMedecin) {
    this.identifiantMedecin = identifiantMedecin;
  }

  public String getNumeroACP() {
    return numeroACP;
  }

  public void setNumeroACP(String numeroACP) {
    this.numeroACP = numeroACP;
  }

  public String getNomEtPrenomMalade() {
  	return nomEtPrenomMalade;
  }
  
  public void setNomEtPrenomMalade(String nomEtPrenomMalade) {
  	this.nomEtPrenomMalade = nomEtPrenomMalade;
  }
}
