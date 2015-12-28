package ki.optisoins;

/**
 * Classe décrivant un acte
 */
public class Acte {

    private String date = "";
    private String origine = "";
    private String amo = "";
    private int fraisDeplacement = 0;
    private String ticketModerateur = "";

    public int getTotal() {
        return getMontantHonoraire() + getFraisDeplacement();
    }

    public int getMontantHonoraire() {
        return  AMOProperties.getAMOValue(getNombreAMO(amo));
    }

    private String getNombreAMO(String designation){
        return designation.toLowerCase().replace("amo", "").trim();
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

    public int getFraisDeplacement() {
        return fraisDeplacement;
    }

    public void setFraisDeplacement(int fraisDeplacement) {
        this.fraisDeplacement = fraisDeplacement;
    }

    public String getTicketModerateur() {
        return ticketModerateur;
    }

    public void setTicketModerateur(String ticketModerateur) {
        this.ticketModerateur = ticketModerateur;
    }
}
