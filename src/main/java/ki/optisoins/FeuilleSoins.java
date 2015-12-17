package ki.optisoins;

import java.util.HashSet;
import java.util.Set;

import static ki.optisoins.PriseEnCharge.*;

/**
 * Classe représentant la feuille de soins d'auxiliaire médicale
 */
public class FeuilleSoins {

    private boolean afficherFond = true;
    private final Set<PriseEnCharge> prisesEnCharge = new HashSet<>();

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String reglementNomPrenom = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String nomBanque = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String numeroCompte = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT, CINQUANTE_POURCENT})
    private String identificationAuxiliaireMedical = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT, CINQUANTE_POURCENT})
    private String dateOrdonnance = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT, CINQUANTE_POURCENT})
    private String nomMedecin = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT, CINQUANTE_POURCENT})
    private String numeroMedecin = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT, CINQUANTE_POURCENT})
    private String numeroACP = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT, CINQUANTE_POURCENT})
    private String nomEtPrenomMalade = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String numeroCafat = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String nomAssure = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String prenomAssure = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String appartement = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String batiment = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String rue = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String codePostal = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String commune = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String accident = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String nomMalade = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String prenomMalade = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String datedenaissance = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String lienAssure = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE, CENT_POURCENT})
    private String situationMalade = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE})
    private String debutValiditeAM = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE})
    private String finValiditeAM = "";

    @Condition(priseEnCharge = {AIDE_MEDICALE})
    private String numeroAM = "";

    public Set<PriseEnCharge> getPrisesEnCharge() {
        return prisesEnCharge;
    }

    public void addToPriseEnCharge(PriseEnCharge priseEnCharge) {
        this.prisesEnCharge.add(priseEnCharge);
    }

    public String getReglementNomPrenom() {
        return reglementNomPrenom;
    }

    public void setReglementNomPrenom(String reglementNomPrenom) {
        this.reglementNomPrenom = reglementNomPrenom;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getIdentificationAuxiliaireMedical() {
        return identificationAuxiliaireMedical;
    }

    public void setIdentificationAuxiliaireMedical(String identificationAuxiliaireMedical) {
        this.identificationAuxiliaireMedical = identificationAuxiliaireMedical;
    }

    public String getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(String dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getNumeroMedecin() {
        return numeroMedecin;
    }

    public void setNumeroMedecin(String numeroMedecin) {
        this.numeroMedecin = numeroMedecin;
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

    public String getNumeroCafat() {
        return numeroCafat;
    }

    public void setNumeroCafat(String numeroCafat) {
        this.numeroCafat = numeroCafat;
    }

    public String getNomAssure() {
        return nomAssure;
    }

    public void setNomAssure(String nomAssure) {
        this.nomAssure = nomAssure;
    }

    public String getPrenomAssure() {
        return prenomAssure;
    }

    public void setPrenomAssure(String prenomAssure) {
        this.prenomAssure = prenomAssure;
    }

    public String getAccident() {
        return accident;
    }

    public void setAccident(String accident) {
        this.accident = accident;
    }

    public String getNomMalade() {
        return nomMalade;
    }

    public void setNomMalade(String nomMalade) {
        this.nomMalade = nomMalade;
    }

    public String getPrenomMalade() {
        return prenomMalade;
    }

    public void setPrenomMalade(String prenomMalade) {
        this.prenomMalade = prenomMalade;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getLienAssure() {
        return lienAssure;
    }

    public void setLienAssure(String lienAssure) {
        this.lienAssure = lienAssure;
    }

    public String getSituationMalade() {
        return situationMalade;
    }

    public void setSituationMalade(String situationMalade) {
        this.situationMalade = situationMalade;
    }

    public String getDebutValiditeAM() {
        return debutValiditeAM;
    }

    public void setDebutValiditeAM(String debutValiditeAM) {
        this.debutValiditeAM = debutValiditeAM;
    }

    public String getFinValiditeAM() {
        return finValiditeAM;
    }

    public void setFinValiditeAM(String finValiditeAM) {
        this.finValiditeAM = finValiditeAM;
    }

    public String getNumeroAM() {
        return numeroAM;
    }

    public void setNumeroAM(String numeroAM) {
        this.numeroAM = numeroAM;
    }

    public boolean isAfficherFond() {
        return afficherFond;
    }

    public void setAfficherFond(boolean afficherFond) {
        this.afficherFond = afficherFond;
    }

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

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }
}
