package ki.optisoins.bdd.xls;

import ki.optisoins.bdd.xls.annotations.*;
import ki.optisoins.utils.AnnotationsUtils;
import ki.optisoins.utils.ReflectUtils;
import ki.optisoins.utils.StringUtils;

import java.util.List;

public class FeuilleSoinsXls {

  @ATechnique
  private String nomFichier = "";

  @ATechnique
  private String nomFeuille = "";

  @ATechnique
  private String numeroLigne = "";

  @ATechnique
  private String numeroEtat = "";

  @AOrthophoniste
  private String reglementNomPrenom = "";
  @AOrthophoniste
  private String nomBanque = "";
  @AOrthophoniste
  private String numeroCompte = "";
  @AOrthophoniste
  private String identificationAuxiliaireMedical = "";

  @AOrdonnanceMedecin
  private String nomMedecin = "";
  @AOrdonnanceMedecin
  private String dateOrdonnance = "";
  @AOrdonnanceMedecin
  private String numeroMedecin = "";
  @AOrdonnanceMedecin
  private String numeroACP = "";
  @AOrdonnanceMedecin
  private String nomEtPrenomMalade = "";

  @AAssure
  private String numeroCafat = "";
  @AAssure
  private String nomAssure = "";
  @AAssure
  private String prenomAssure = "";
  @AAssure
  private String datedenaissanceAssure = "";

  @AAssure
  @AAdresse
  private String appartement = "";
  @AAssure
  @AAdresse
  private String batiment = "";
  @AAssure
  @AAdresse
  private String rue = "";
  @AAssure
  @AAdresse
  private String codePostal = "";
  @AAssure
  @AAdresse
  private String commune = "";

  @AAssure
  @AAideMedicale
  private String debutValiditeAM = "";
  @AAssure
  @AAideMedicale
  private String finValiditeAM = "";
  @AAssure
  @AAideMedicale
  private String numeroAM = "";

  @AMalade
  private String accident = "";
  @AMalade
  private String nomMalade = "";
  @AMalade
  private String prenomMalade = "";
  @AMalade
  private String datedenaissanceMalade = "";
  @AMalade
  private String lienAssure = "";
  @AMalade
  private String situationMalade = "";

  private String ticketModerateur = "";
  private String amo = "";

  @AActes
  private String acte1 = "";
  @AActes
  private String acte2 = "";
  @AActes
  private String acte3 = "";
  @AActes
  private String acte4 = "";
  @AActes
  private String acte5 = "";
  @AActes
  private String acte6 = "";
  @AActes
  private String acte7 = "";
  @AActes
  private String acte8 = "";
  @AActes
  private String acte9 = "";
  @AActes
  private String acte10 = "";
  @AActes
  private String acte11 = "";

  public String getNomFeuille() {
    return nomFeuille;
  }

  public void setNomFeuille(String nomFeuille) {
    this.nomFeuille = nomFeuille;
  }

  public String getNomFichier() {
    return nomFichier;
  }

  public void setNomFichier(String nomFichier) {
    this.nomFichier = nomFichier;
  }

  public String getNumeroLigne() {
    return numeroLigne;
  }

  public void setNumeroLigne(String numeroLigne) {
    this.numeroLigne = numeroLigne;
  }

  public String getNomBanque() {
    return nomBanque;
  }

  public void setNomBanque(String nomBanque) {
    this.nomBanque = nomBanque;
  }

  public String getIdentificationAuxiliaireMedical() {
    return identificationAuxiliaireMedical;
  }

  public void setIdentificationAuxiliaireMedical(String identificationAuxiliaireMedical) {
    this.identificationAuxiliaireMedical = identificationAuxiliaireMedical;
  }

  public String getNomMedecin() {
    return nomMedecin;
  }

  public void setNomMedecin(String nomMedecin) {
    this.nomMedecin = nomMedecin;
  }

  public String getDateOrdonnance() {
    return dateOrdonnance;
  }

  public void setDateOrdonnance(String dateOrdonnance) {
    this.dateOrdonnance = dateOrdonnance;
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

  public String getReglementNomPrenom() {
    return reglementNomPrenom;
  }

  public void setReglementNomPrenom(String reglementNomPrenom) {
    this.reglementNomPrenom = reglementNomPrenom;
  }

  public String getNumeroCompte() {
    return numeroCompte;
  }

  public void setNumeroCompte(String numeroCompte) {
    this.numeroCompte = numeroCompte;
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

  public String getDatedenaissanceAssure() {
    return datedenaissanceAssure;
  }

  public void setDatedenaissanceAssure(String datedenaissanceAssure) {
    this.datedenaissanceAssure = datedenaissanceAssure;
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

  public String getTicketModerateur() {
    return ticketModerateur;
  }

  public void setTicketModerateur(String ticketModerateur) {
    this.ticketModerateur = ticketModerateur;
  }

  public String getAmo() {
    return amo;
  }

  public void setAmo(String amo) {
    this.amo = amo;
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

 
  public String getNumeroEtat() {
    return numeroEtat;
  }

  public void setNumeroEtat(String numeroEtat) {
    this.numeroEtat = numeroEtat;
  }

  @Override
  public String toString() {
    return StringUtils.concat("\n", super.toString(), ReflectUtils.toStringFields(this));
  }

  public String getInformations() {
    return "nom du fichier : '" + getNomFichier() + "', nom de la feuille Xls : " + getNomFeuille() + "', numéro de la ligne : '" + getNumeroLigne() + "'";
  }

  public static String getNomsChampsAutorises() {
    String nomsChampsAutorises = "";
    for (String nomChampAutorise : getAttributsMetier()) {
      nomsChampsAutorises = StringUtils.concat(" ", nomsChampsAutorises, nomChampAutorise);
    }
    return nomsChampsAutorises;
  }

  public static List<String> getAttributsTechniques() {
    return AnnotationsUtils.getFieldsNameWithAnnotation(FeuilleSoinsXls.class, ATechnique.class);
  }

  public static List<String> getAttributsMetier() {
    return AnnotationsUtils.getFieldsNameWithoutAnnotation(FeuilleSoinsXls.class, ATechnique.class);
  }
}
