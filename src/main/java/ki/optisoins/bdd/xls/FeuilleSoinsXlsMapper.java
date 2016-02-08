package ki.optisoins.bdd.xls;

import ki.optisoins.bdd.xls.annotations.*;
import ki.optisoins.pojo.*;
import ki.optisoins.utils.AnnotationsUtils;
import ki.optisoins.utils.StringUtils;

public class FeuilleSoinsXlsMapper {

  public FeuilleSoins map(FeuilleSoinsXls feuilleSoinsXls) {
    FeuilleSoins feuilleSoins = new FeuilleSoins();
    feuilleSoins.setNumeroEtat(feuilleSoinsXls.getNumeroEtat());
    feuilleSoins.setPriseEnCharge(PriseEnCharge.getPriseEnCharge(feuilleSoinsXls.getNomFeuille()));
    feuilleSoins.setAttributsTechnique(mapAttributsTechnique(feuilleSoinsXls));
    feuilleSoins.setAssure(mapAssure(feuilleSoinsXls));
    feuilleSoins.setMalade(mapMalade(feuilleSoinsXls));
    feuilleSoins.setOrthophoniste(mapOrthophoniste(feuilleSoinsXls));
    feuilleSoins.setOrdonnanceMedecin(mapOrdonnanceMedecin(feuilleSoinsXls));
    feuilleSoins.setActes(mapActes(feuilleSoins, feuilleSoinsXls));
    return feuilleSoins;
  }


  private AttributsTechnique mapAttributsTechnique(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, ATechnique.class)) {
      AttributsTechnique attributsTechnique = new AttributsTechnique();
      attributsTechnique.setId(StringUtils.concat("-", fsXls.getNomFichier(), fsXls.getNomFeuille(), fsXls.getNumeroLigne()));
      return attributsTechnique;
    }
    throw new RuntimeException("un problème technique est survenu, la feuille de soins n'a pas d'attribut technique");
  }

  private Assure mapAssure(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AAssure.class)) {
      Assure assure = new Assure();
      assure.setNom(fsXls.getNomAssure());
      assure.setPrenom(fsXls.getPrenomAssure());
      assure.setNumeroCafat(fsXls.getNumeroCafat());
      assure.setDateNaissance(toDate(fsXls.getDatedenaissanceAssure()));
      assure.setAideMedicale(mapAideMedicale(fsXls));
      assure.setAdresse(mapAdresse(fsXls));
      assure.setMutuelleComplementaire(null);
      assure.setMutuellePrincipale(null);
      assure.setNumeroNCS("");
      return assure;
    }
    return null;
  }

  private AideMedicale mapAideMedicale(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AAideMedicale.class)) {
      AideMedicale aideMedicale = new AideMedicale();
      aideMedicale.setLocalisationAM(LocalisationAM.getLocalisationAM(fsXls.getLocalisationAM()));
      aideMedicale.setDateDebutValidite(toDate(fsXls.getDebutValiditeAM()));
      aideMedicale.setNumero(fsXls.getNumeroAM());
      aideMedicale.setDateFinValidite(toDate(fsXls.getFinValiditeAM()));
      return aideMedicale;
    }
    return null;
  }

  private Adresse mapAdresse(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AAdresse.class)) {
      Adresse adresse = new Adresse();
      adresse.setAppartement(fsXls.getAppartement());
      adresse.setBatiment(fsXls.getBatiment());
      adresse.setBoitePostale("");
      adresse.setCodePostal(fsXls.getCodePostal());
      adresse.setCommune(fsXls.getCommune());
      adresse.setRue(fsXls.getRue());
      return adresse;
    }
    return null;
  }

  private Malade mapMalade(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AMalade.class)) {
      Malade malade = new Malade();
      malade.setAccident(mapAccident(fsXls));
      malade.setDateNaissance(toDate(fsXls.getDatedenaissanceMalade()));
      malade.setEmployeur("");
      malade.setLienAvecAssure(LienAssure.get(fsXls.getLienAssure()));
      malade.setNom(fsXls.getNomMalade());
      malade.setPrenom(fsXls.getPrenomMalade());
      malade.setSituationMalade(fsXls.getSituationMalade());
      return malade;
    }
    return null;
  }

  private Accident mapAccident(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AMalade.class) && StringUtils.isNotEmpty(fsXls.getAccident())) {
      Accident accident = new Accident();
      accident.setAccident(isAccident(fsXls.getAccident()));
      accident.setDateAccident("");
      accident.setNomTierImpliqueAccident("");
      return accident;
    }
    return null;
  }

  private boolean isAccident(String accident) {
    return StringUtils.toBoolean(accident);
  }

  private Orthophoniste mapOrthophoniste(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AOrthophoniste.class)) {
      Orthophoniste orthophoniste = new Orthophoniste();
      orthophoniste.setNomEtPrenom(fsXls.getReglementNomPrenom());
      orthophoniste.setIdentification(fsXls.getIdentificationAuxiliaireMedical());
      orthophoniste.setCompteBancaire(mapCompteBancaire(fsXls));
      return orthophoniste;
    }
    return null;
  }

  private CompteBancaire mapCompteBancaire(FeuilleSoinsXls fsXls) {
    CompteBancaire compteBancaire = new CompteBancaire();
    compteBancaire.setNomBanque(fsXls.getNomBanque());
    compteBancaire.setNumeroCompte(fsXls.getNumeroCompte());
    return compteBancaire;
  }

  private OrdonnanceMedecin mapOrdonnanceMedecin(FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AOrdonnanceMedecin.class)) {
      OrdonnanceMedecin ordonnanceMedecin = new OrdonnanceMedecin();
      ordonnanceMedecin.setDatePrescription(toDate(fsXls.getDateOrdonnance()));
      ordonnanceMedecin.setIdentifiantMedecin(fsXls.getNumeroMedecin());
      ordonnanceMedecin.setNomEtPrenomMalade(getNomEtPrenomMalade(fsXls));
      ordonnanceMedecin.setNumeroACP(fsXls.getNumeroACP());
      ordonnanceMedecin.setNomMedecin(fsXls.getNomMedecin());
      return ordonnanceMedecin;
    }
    return null;
  }

  private String getNomEtPrenomMalade(FeuilleSoinsXls fsXls) {
    if (StringUtils.isNotEmpty(fsXls.getNomEtPrenomMalade())) {
      return fsXls.getNomEtPrenomMalade();
    } else if (StringUtils.isNotEmpty(fsXls.getNomMalade() + fsXls.getPrenomMalade())) {
      return fsXls.getNomMalade() + " " + fsXls.getPrenomMalade();
    } else if (StringUtils.isNotEmpty(fsXls.getNomAssure() + fsXls.getPrenomAssure())) {
      return fsXls.getNomAssure() + " " + fsXls.getPrenomAssure();
    }
    return "";
  }

  private Actes mapActes(FeuilleSoins feuilleSoins, FeuilleSoinsXls fsXls) {
    if (AnnotationsUtils.isFieldNotEmpty(fsXls, AActes.class)) {
      Actes actes = new Actes();
      actes.setToActes(1, mapActe(feuilleSoins, fsXls, fsXls.getActe1()));
      actes.setToActes(2, mapActe(feuilleSoins, fsXls, fsXls.getActe2()));
      actes.setToActes(3, mapActe(feuilleSoins, fsXls, fsXls.getActe3()));
      actes.setToActes(4, mapActe(feuilleSoins, fsXls, fsXls.getActe4()));
      actes.setToActes(5, mapActe(feuilleSoins, fsXls, fsXls.getActe5()));
      actes.setToActes(6, mapActe(feuilleSoins, fsXls, fsXls.getActe6()));
      actes.setToActes(7, mapActe(feuilleSoins, fsXls, fsXls.getActe7()));
      actes.setToActes(8, mapActe(feuilleSoins, fsXls, fsXls.getActe8()));
      actes.setToActes(9, mapActe(feuilleSoins, fsXls, fsXls.getActe9()));
      actes.setToActes(10, mapActe(feuilleSoins, fsXls, fsXls.getActe10()));
      actes.setToActes(11, mapActe(feuilleSoins, fsXls, fsXls.getActe11()));
      return actes;
    }
    return null;
  }

  private Acte mapActe(FeuilleSoins feuilleSoins, FeuilleSoinsXls fsXls, String dateActe) {
    if (StringUtils.isNotEmpty(dateActe)) {
      Acte acte = new Acte();
      acte.setAmo(fsXls.getAmo());
      acte.setDate(toDate(dateActe));
      acte.setDomicile(feuilleSoins.isDomicile());
      acte.setTicketModerateur(fsXls.getTicketModerateur());
      acte.setOrigine("");
      return acte;
    }
    return null;
  }

  private String toDate(String datedenaissanceAssure) {
    return datedenaissanceAssure;
  }
}
