package ki.optisoins.pojo;

import ki.optisoins.properties.AMOProperties;

/**
 * Classe décrivant un acte
 */
public class Acte {

  private static final int MONTANT_FRAIS_DEPLACEMENT_DEFAULT = 320;

  private String date = "";
  private String origine = "";
  private String amo = "";
  private boolean domicile = false;
  private Boolean ticketModerateur = false;

  public int getTotal() {
    return getMontantHonoraire() + getFraisDeplacement() - getMontantTicketModerateur();
  }

  public int getTotalSansTicketModerateur() {
    return getMontantHonoraire() + getFraisDeplacement();
  }
  
  private int getMontantTicketModerateur() {
    if (Boolean.TRUE.equals(ticketModerateur)) {
      return (int)(getMontantHonoraire() * 0.1);
    }
    return 0;
  }

  public int getMontantHonoraire() {
    return AMOProperties.getAMOValue(getNombreAMO(amo));
  }

  private String getNombreAMO(String designation) {
    return designation.toLowerCase().replace("amo", "").trim();
  }

  public int getFraisDeplacement() {
    return isDomicile() ? MONTANT_FRAIS_DEPLACEMENT_DEFAULT : 0;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getOrigine() {
    return origine;
  }

  public void setOrigine(String origine) {
    this.origine = origine;
  }

  public String getAmo() {
    return amo;
  }

  public void setAmo(String amo) {
    this.amo = amo;
  }

  public void setTicketModerateur(Boolean ticketModerateur) {
    this.ticketModerateur = ticketModerateur;
  }

  public Boolean getTicketModerateur() {
    return ticketModerateur;
  }

  public boolean isDomicile() {
    return domicile;
  }

  public void setDomicile(boolean domicile) {
    this.domicile = domicile;
  }
}