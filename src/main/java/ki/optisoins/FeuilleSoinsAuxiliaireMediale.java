package ki.optisoins;

/**
 * Classe représentant la feuille de soins d'auxiliaire médicale
 */
public class FeuilleSoinsAuxiliaireMediale {

    private String reglementNomPrenom = "Vantomme Corinne";
    private String nomBanque = "BCI";
    private String numeroCompte = "1 7 4 9 9 0 0 0 1 0 2 7 9 1 6 3 0 2 0 1 3 7 4";


    public String getNomBanque() {
        return nomBanque;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getReglementNomPrenom() {

        return reglementNomPrenom;
    }

    public void setReglementNomPrenom(String reglementNomPrenom) {
        this.reglementNomPrenom = reglementNomPrenom;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
}
