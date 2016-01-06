package ki.optisoins.pojo;

public class Accident {
  private boolean accident = false;
  private String dateAccident = "";
  private String nomTierImpliqueAccident = "";

  public boolean isAccident() {
    return accident;
  }

  public void setAccident(boolean accident) {
    this.accident = accident;
  }

  public String getDateAccident() {
    return dateAccident;
  }

  public void setDateAccident(String dateAccident) {
    this.dateAccident = dateAccident;
  }

  public String getNomTierImpliqueAccident() {
    return nomTierImpliqueAccident;
  }

  public void setNomTierImpliqueAccident(String nomTierImpliqueAccident) {
    this.nomTierImpliqueAccident = nomTierImpliqueAccident;
  }
}
