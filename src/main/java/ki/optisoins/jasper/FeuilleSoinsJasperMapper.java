package ki.optisoins.jasper;

import ki.optisoins.pojo.*;

import java.util.List;
import java.util.stream.Collectors;

public class FeuilleSoinsJasperMapper {

  public List<FeuilleSoinsJasper> map(List<FeuilleSoins> feuillesSoins) {
    return feuillesSoins.stream().map(this::map).collect(Collectors.toList());
  }

  public FeuilleSoinsJasper map(FeuilleSoins feuilleSoins) {
    FeuilleSoinsJasper feuilleSoinsJasper = new FeuilleSoinsJasper();
    mapAssure(feuilleSoinsJasper, feuilleSoins);
    mapMalade(feuilleSoinsJasper, feuilleSoins);
    mapOrthophoniste(feuilleSoinsJasper, feuilleSoins);
    mapOrdonnanceMedecin(feuilleSoinsJasper, feuilleSoins);
    mapActes(feuilleSoinsJasper, feuilleSoins);
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapAssure(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    Assure assure = feuilleSoins.getAssure();
    if (assure != null) {
      feuilleSoinsJasper.setNumeroCafat(FeuilleSoinsJasperFormat.formatAssureNumeroCafat(assure.getNumeroCafat()));
      feuilleSoinsJasper.setDatedenaissanceAssure(assure.getDateNaissance());
      feuilleSoinsJasper.setNomAssure(assure.getNom());
      feuilleSoinsJasper.setPrenomAssure(assure.getPrenom());

      mapAdresse(feuilleSoinsJasper, feuilleSoins);
      mapAideMedicale(feuilleSoinsJasper, feuilleSoins);
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapAdresse(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    Adresse adresse = feuilleSoins.getAssure().getAdresse();
    if (adresse != null) {
      feuilleSoinsJasper.setRue(adresse.getRue());
      feuilleSoinsJasper.setAppartement(adresse.getAppartement());
      feuilleSoinsJasper.setBatiment(adresse.getBatiment());
      feuilleSoinsJasper.setCodePostal(adresse.getCodePostal());
      feuilleSoinsJasper.setCommune(adresse.getCommune());
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapAideMedicale(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    AideMedicale aideMedicale = feuilleSoins.getAssure().getAideMedicale();
    if (aideMedicale != null) {
      feuilleSoinsJasper.setDebutValiditeAM(aideMedicale.getDateDebutValidite());
      feuilleSoinsJasper.setFinValiditeAM(aideMedicale.getDateFinValidite());
      feuilleSoinsJasper.setNumeroAM(aideMedicale.getNumero());
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapMalade(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    Malade malade = feuilleSoins.getMalade();
    if (malade != null) {
      feuilleSoinsJasper.setNomMalade(malade.getNom());
      feuilleSoinsJasper.setPrenomMalade(malade.getPrenom());
      feuilleSoinsJasper.setSituationMalade(malade.getSituationMalade());
      feuilleSoinsJasper.setLienAssure(malade.getLienAvecAssure() != null ? malade.getLienAvecAssure().getValue() : "");
      mapAccident(feuilleSoinsJasper, feuilleSoins);
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapAccident(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    Accident accident = feuilleSoins.getMalade().getAccident();
    feuilleSoinsJasper.setAccident(accident != null);
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapOrthophoniste(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    Orthophoniste orthophoniste = feuilleSoins.getOrthophoniste();
    if (orthophoniste != null) {
      feuilleSoinsJasper.setReglementNomPrenom(orthophoniste.getNomEtPrenom());
      feuilleSoinsJasper.setIdentificationAuxiliaireMedical(orthophoniste.getIdentification());
      mapCompteBancaire(feuilleSoinsJasper, feuilleSoins);
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapCompteBancaire(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    CompteBancaire compteBancaire = feuilleSoins.getOrthophoniste().getCompteBancaire();
    if (compteBancaire != null) {
      feuilleSoinsJasper.setNomBanque(compteBancaire.getNomBanque());
      feuilleSoinsJasper.setNumeroCompte(FeuilleSoinsJasperFormat.formatNumeroCompte(compteBancaire.getNumeroCompte()));
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapOrdonnanceMedecin(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    OrdonnanceMedecin ordonnanceMedecin = feuilleSoins.getOrdonnanceMedecin();
    if (ordonnanceMedecin != null) {
      feuilleSoinsJasper.setNomEtPrenomMalade(ordonnanceMedecin.getNomEtPrenomMalade());
      feuilleSoinsJasper.setNomMedecin(ordonnanceMedecin.getNomMedecin());
      feuilleSoinsJasper.setDateOrdonnance(ordonnanceMedecin.getDatePrescription());
      feuilleSoinsJasper.setNumeroMedecin(ordonnanceMedecin.getIdentifiantMedecin());
      feuilleSoinsJasper.setNumeroACP(ordonnanceMedecin.getNumeroACP());
    }
    return feuilleSoinsJasper;
  }

  private FeuilleSoinsJasper mapActes(FeuilleSoinsJasper feuilleSoinsJasper, FeuilleSoins feuilleSoins) {
    Actes actes = feuilleSoins.getActes();
    if (actes != null) {
      feuilleSoinsJasper.setActe1(FeuilleSoinsJasperFormat.formatActe(actes.getActe(1)));
      feuilleSoinsJasper.setActe2(FeuilleSoinsJasperFormat.formatActe(actes.getActe(2)));
      feuilleSoinsJasper.setActe3(FeuilleSoinsJasperFormat.formatActe(actes.getActe(3)));
      feuilleSoinsJasper.setActe4(FeuilleSoinsJasperFormat.formatActe(actes.getActe(4)));
      feuilleSoinsJasper.setActe5(FeuilleSoinsJasperFormat.formatActe(actes.getActe(5)));
      feuilleSoinsJasper.setActe6(FeuilleSoinsJasperFormat.formatActe(actes.getActe(6)));
      feuilleSoinsJasper.setActe7(FeuilleSoinsJasperFormat.formatActe(actes.getActe(7)));
      feuilleSoinsJasper.setActe8(FeuilleSoinsJasperFormat.formatActe(actes.getActe(8)));
      feuilleSoinsJasper.setActe9(FeuilleSoinsJasperFormat.formatActe(actes.getActe(9)));
      feuilleSoinsJasper.setActe10(FeuilleSoinsJasperFormat.formatActe(actes.getActe(10)));
      feuilleSoinsJasper.setActe11(FeuilleSoinsJasperFormat.formatActe(actes.getActe(11)));
      feuilleSoinsJasper.setTotal(FeuilleSoinsJasperFormat.formatXPF(actes.calculerTotal()));
    }

    return feuilleSoinsJasper;
  }
}
