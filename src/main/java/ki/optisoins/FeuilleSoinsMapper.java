package ki.optisoins;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeuilleSoinsMapper {

    public List<FeuilleSoinsJasper> map(List<Map<String, Object>> donneesExtraites) {
        List<FeuilleSoinsJasper> feuillesSoinsAuxiliaireMediales = new ArrayList<>();
        for (Map<String, Object> donneesFeuille : donneesExtraites) {
            feuillesSoinsAuxiliaireMediales.add(map(donneesFeuille));
        }
        return feuillesSoinsAuxiliaireMediales;
    }

    private FeuilleSoinsJasper map(Map<String, Object> donneesFeuille) {
        FeuilleSoinsJasper feuilleSoinsJasperAuxiliaireMediale = new FeuilleSoinsJasper();

        for (String nomChamp : donneesFeuille.keySet()) {
            map(feuilleSoinsJasperAuxiliaireMediale, nomChamp, donneesFeuille.get(nomChamp));
        }
        return feuilleSoinsJasperAuxiliaireMediale;
    }

    private FeuilleSoinsJasper map(FeuilleSoinsJasper feuille, String nomChamp, Object donnees) {
        switch (nomChamp) {
            case FeuilleSoinsChamps.NOMBANQUE_CHAMP:
                return mapChampNomBanque(feuille, donnees);
            case FeuilleSoinsChamps.REGLEMENTNOMPRENOM_CHAMP:
                return mapReglementNomPrenom(feuille, donnees);
            case FeuilleSoinsChamps.NUMEROCOMPTE_CHAMP:
                return mapChampNumeroCompte(feuille, donnees);
            case FeuilleSoinsChamps.IDENTIFICATIONAUXILIAIREMEDICAL_CHAMP:
                return mapChampIdentificationAuxiliaireMedical(feuille, donnees);
            case FeuilleSoinsChamps.DATEORDONNANCE_CHAMP:
                return mapChampDateOrdonnance(feuille, donnees);
            case FeuilleSoinsChamps.NOMMEDECIN_CHAMP:
                return mapChampNomMedecin(feuille, donnees);
            case FeuilleSoinsChamps.NUMEROMEDECIN_CHAMP:
                return mapChampNumeroMedecin(feuille, donnees);
            case FeuilleSoinsChamps.NUMEROACP_CHAMP:
                return mapChampNumeroACP(feuille, donnees);
            case FeuilleSoinsChamps.NOMETPRENOMMALADE_CHAMP:
                return mapChampNomEtPrenomMalade(feuille, donnees);
            case FeuilleSoinsChamps.NUMEROCAFAT_CHAMP:
                return mapChampNumeroCafat(feuille, donnees);
            case FeuilleSoinsChamps.NOMASSURE_CHAMP:
                return mapChampNomAssure(feuille, donnees);
            case FeuilleSoinsChamps.PRENOMASSURE_CHAMP:
                return mapChampPrenomAssure(feuille, donnees);
            case FeuilleSoinsChamps.DATEDENAISSANCEASSURE_CHAMP:
                return mapChampDatedenaissanceAssure(feuille, donnees);
            case FeuilleSoinsChamps.APPARTEMENT_CHAMP:
                return mapChampAppartement(feuille, donnees);
            case FeuilleSoinsChamps.BATIMENT_CHAMP:
                return mapChampBatiment(feuille, donnees);
            case FeuilleSoinsChamps.RUE_CHAMP:
                return mapChampRue(feuille, donnees);
            case FeuilleSoinsChamps.CODEPOSTAL_CHAMP:
                return mapChampCodePostal(feuille, donnees);
            case FeuilleSoinsChamps.COMMUNE_CHAMP:
                return mapChampCommune(feuille, donnees);
              case FeuilleSoinsChamps.ACCIDENT_CHAMP:
                return mapChampAccident(feuille, donnees);
            case FeuilleSoinsChamps.NOMMALADE_CHAMP:
                return mapChampNomMalade(feuille, donnees);
            case FeuilleSoinsChamps.PRENOMMALADE_CHAMP:
                return mapChampPrenomMalade(feuille, donnees);
            case FeuilleSoinsChamps.DATEDENAISSANCEMALADE_CHAMP:
                return mapChampDatedenaissance(feuille, donnees);
            case FeuilleSoinsChamps.LIENASSURE_CHAMP:
                return mapChampLienAssure(feuille, donnees);
            case FeuilleSoinsChamps.SITUATIONMALADE_CHAMP:
                return mapChampSituationMalade(feuille, donnees);
            case FeuilleSoinsChamps.DEBUTVALIDITEAM_CHAMP:
                return mapChampDebutValiditeAM(feuille, donnees);
            case FeuilleSoinsChamps.FINVALIDITEAM_CHAMP:
                return mapChampFinValiditeAM(feuille, donnees);
            case FeuilleSoinsChamps.NUMEROAM_CHAMP:
                return mapChampNumeroAM(feuille, donnees);
            case FeuilleSoinsChamps.NOMDOSSIER_CHAMP:
                return mapChampNomDossier(feuille, donnees);
            case FeuilleSoinsChamps.AMO_CHAMP:
                return mapChampAMO(feuille, donnees);
            case FeuilleSoinsChamps.TICKETMODERATEUR_CHAMP:
                return mapChampTicketModerateur(feuille, donnees);
            case FeuilleSoinsChamps.ACTE1_CHAMP:
                return mapActe1(feuille, donnees);
            case FeuilleSoinsChamps.ACTE2_CHAMP:
                return mapActe2(feuille, donnees);
            case FeuilleSoinsChamps.ACTE3_CHAMP:
                return mapActe3(feuille, donnees);
            case FeuilleSoinsChamps.ACTE4_CHAMP:
                return mapActe4(feuille, donnees);
            case FeuilleSoinsChamps.ACTE5_CHAMP:
                return mapActe5(feuille, donnees);
            case FeuilleSoinsChamps.ACTE6_CHAMP:
                return mapActe6(feuille, donnees);
            case FeuilleSoinsChamps.ACTE7_CHAMP:
                return mapActe7(feuille, donnees);
            case FeuilleSoinsChamps.ACTE8_CHAMP:
                return mapActe8(feuille, donnees);
            case FeuilleSoinsChamps.ACTE9_CHAMP:
                return mapActe9(feuille, donnees);
            case FeuilleSoinsChamps.ACTE10_CHAMP:
                return mapActe10(feuille, donnees);
            case FeuilleSoinsChamps.ACTE11_CHAMP:
                return mapActe11(feuille, donnees);
             default:
                return feuille;
        }
    }


	private FeuilleSoinsJasper mapActe11(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(11, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe10(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(10, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe9(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(9, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe8(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(8, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe7(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(7, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe6(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(6, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe5(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(5, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe4(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(4, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe3(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(3, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe2(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(2, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapActe1(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.addToActes(1, JasperUtils.createActe(convertToString(donnees)));
        return feuille;
    }


	private FeuilleSoinsJasper mapChampTicketModerateur(FeuilleSoinsJasper feuille, Object donnees) {
		feuille.setTicketModerateur(convertToString(donnees));
		return feuille;
	}

	private FeuilleSoinsJasper mapChampAMO(FeuilleSoinsJasper feuille,Object donnees) {
		feuille.setAmo(convertToString(donnees));
		return feuille;
	}
    
    private FeuilleSoinsJasper mapChampNomDossier(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNomDossier(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNumeroAM(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNumeroAM(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampFinValiditeAM(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setFinValiditeAM(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampDebutValiditeAM(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setDebutValiditeAM(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampSituationMalade(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setSituationMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampLienAssure(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setLienAssure(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampDatedenaissance(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setDatedenaissanceMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampPrenomMalade(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setPrenomMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNomMalade(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNomMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampAccident(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setAccident(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampBatiment(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setBatiment(convertToString(donnees));
        return feuille;
    }


    private FeuilleSoinsJasper mapChampAppartement(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setAppartement(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampRue(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setRue(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampCodePostal(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setCodePostal(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampCommune(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setCommune(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampPrenomAssure(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setPrenomAssure(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNomAssure(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNomAssure(convertToString(donnees));
        return feuille;
    }
    

    private FeuilleSoinsJasper mapChampDatedenaissanceAssure(FeuilleSoinsJasper feuille, Object donnees) {
    	feuille.setDatedenaissanceAssure(convertToString(donnees));
		return feuille;
	}


    private FeuilleSoinsJasper mapChampNumeroCafat(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNumeroCafat(String.valueOf(convertNumberToIntegerString(donnees)));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNomEtPrenomMalade(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNomEtPrenomMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNumeroACP(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNumeroACP(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNumeroMedecin(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNumeroMedecin(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNomMedecin(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNomMedecin(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampDateOrdonnance(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setDateOrdonnance(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampIdentificationAuxiliaireMedical(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setIdentificationAuxiliaireMedical(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNumeroCompte(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNumeroCompte(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoinsJasper mapReglementNomPrenom(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setReglementNomPrenom(donnees != null ? convertToString(donnees) : "");
        return feuille;
    }

    private FeuilleSoinsJasper mapChampNomBanque(FeuilleSoinsJasper feuille, Object donnees) {
        feuille.setNomBanque(convertToString(donnees));
        return feuille;
    }

    private String convertToString(Object donnees) {
        return donnees != null ? String.valueOf(donnees) : "";
    }

    private Object convertNumberToIntegerString(Object donnees) {
        if (donnees instanceof Number){
            donnees = ((Number) donnees).intValue();
        }
        return convertToString(donnees);
    }

}
