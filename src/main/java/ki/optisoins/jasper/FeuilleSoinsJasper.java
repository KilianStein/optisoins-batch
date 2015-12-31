package ki.optisoins.jasper;

import ki.optisoins.pojo.Acte;
import ki.optisoins.pojo.Actes;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.properties.ConfigurationPropertiesValue;

/**
 * Classe représentant la feuille de soins d'auxiliaire médicale
 */
public class FeuilleSoinsJasper {

    private String nomDossier = "";

    private String reglementNomPrenom = "";
    private String nomBanque = "";
    private String numeroCompte = "";
    private String identificationAuxiliaireMedical = "";
    private String dateOrdonnance = "";
    private String nomMedecin = "";
    private String numeroMedecin = "";
    private String numeroACP = "";
    private String nomEtPrenomMalade = "";
    private String numeroCafat = "";
    private String nomAssure = "";
    private String prenomAssure = "";
    private String datedenaissanceAssure = "";
    private String appartement = "";
    private String batiment = "";
    private String rue = "";
    private String codePostal = "";
    private String commune = "";
    private boolean accident = false;
    private String nomMalade = "";
    private String prenomMalade = "";
    private String datedenaissanceMalade = "";
    private String lienAssure = "";
    private String situationMalade = "";
    private String debutValiditeAM = "";
    private String finValiditeAM = "";
    private String numeroAM = "";
    private String amo = "";
    private String ticketModerateur = "";

    private Actes actes = new Actes();
    private String acte1 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte2 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte3 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte4 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte5 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte6 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte7 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte8 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte9 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte10 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;
    private String acte11 = FeuilleSoinsJasperFormat.ACTE_DEFAULT_FORMAT;

    private String total = "";

    private boolean afficherFond = ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.AFFICHER_FOND);
    private boolean debugBordures = ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.AFFICHER_BORDURES);

    public int calculerTotal() {
        return actes.calculerTotal();
    }

    public void updateActes(){
    	actes.update(getAmo(), getTicketModerateur(), isDeplacement());
    }
    
    public Acte getActe(int numeroLigne) {
        return actes.getActe(numeroLigne);
    }

    public void addToActes(int numeroLigne, Acte acte) {
        actes.setToActes(numeroLigne, acte);
    }
    
    public boolean isDeplacement(){
    	return !"".equals(appartement) || !"".equals(batiment) || !"".equals(rue) || !"".equals(codePostal) || !"".equals(commune);
    }

    public boolean isAfficherFond() {
        return afficherFond;
    }

    public void setAfficherFond(boolean afficherFond) {
        this.afficherFond = afficherFond;
    }

    public boolean isDebugBordures() {
        return debugBordures;
    }

    public void setDebugBordures(boolean debugBordures) {
        this.debugBordures = debugBordures;
    }

    public String getNomDossier() {
        return nomDossier;
    }

    public void setNomDossier(String nomDossier) {
        this.nomDossier = nomDossier;
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

    public String getDatedenaissanceMalade() {
        return datedenaissanceMalade;
    }

    public void setDatedenaissanceMalade(String datedenaissanceMalade) {
        this.datedenaissanceMalade = datedenaissanceMalade;
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

    public String getActe1() {
        return acte1;
    }

    public void setActe1(String acte1) {
        this.acte1 = acte1;
    }

    public String getActe2() {
        return acte2;
    }

    public void setActe2(String acte2) {
        this.acte2 = acte2;
    }

    public String getActe3() {
        return acte3;
    }

    public void setActe3(String acte3) {
        this.acte3 = acte3;
    }

    public String getActe4() {
        return acte4;
    }

    public void setActe4(String acte4) {
        this.acte4 = acte4;
    }

    public String getActe5() {
        return acte5;
    }

    public void setActe5(String acte5) {
        this.acte5 = acte5;
    }

    public String getActe6() {
        return acte6;
    }

    public void setActe6(String acte6) {
        this.acte6 = acte6;
    }

    public String getActe7() {
        return acte7;
    }

    public void setActe7(String acte7) {
        this.acte7 = acte7;
    }

    public String getActe8() {
        return acte8;
    }

    public void setActe8(String acte8) {
        this.acte8 = acte8;
    }

    public String getActe9() {
        return acte9;
    }

    public void setActe9(String acte9) {
        this.acte9 = acte9;
    }

    public String getActe10() {
        return acte10;
    }

    public void setActe10(String acte10) {
        this.acte10 = acte10;
    }

    public String getActe11() {
        return acte11;
    }

    public void setActe11(String acte11) {
        this.acte11 = acte11;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

	public String getDatedenaissanceAssure() {
		return datedenaissanceAssure;
	}

	public void setDatedenaissanceAssure(String datedenaissanceAssure) {
		this.datedenaissanceAssure = datedenaissanceAssure;
	}

	public String getAmo() {
		return amo;
	}

	public void setAmo(String amo) {
		this.amo = amo;
	}

	public String getTicketModerateur() {
		return ticketModerateur;
	}

	public void setTicketModerateur(String ticketModerateur) {
		this.ticketModerateur = ticketModerateur;
	}

    public boolean isAccident() {
        return accident;
    }

    public void setAccident(boolean accident) {
        this.accident = accident;
    }
}
