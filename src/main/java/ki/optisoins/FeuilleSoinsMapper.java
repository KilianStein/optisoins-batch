package ki.optisoins;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeuilleSoinsMapper {

    public List<FeuilleSoins> map(List<Map<String, Object>> donneesExtraites) {
        List<FeuilleSoins> feuillesSoinsAuxiliaireMediales = new ArrayList<>();
        for (Map<String, Object> donneesFeuille : donneesExtraites) {
            feuillesSoinsAuxiliaireMediales.add(map(donneesFeuille));
        }
        return feuillesSoinsAuxiliaireMediales;
    }

    private FeuilleSoins map(Map<String, Object> donneesFeuille) {
        FeuilleSoins feuilleSoinsAuxiliaireMediale = new FeuilleSoins();

        for (String nomChamp : donneesFeuille.keySet()) {
            map(feuilleSoinsAuxiliaireMediale, nomChamp, donneesFeuille.get(nomChamp));
        }
        return feuilleSoinsAuxiliaireMediale;
    }

    private FeuilleSoins map(FeuilleSoins feuille, String nomChamp, Object donnees) {
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
            case FeuilleSoinsChamps.ADRESSE_CHAMP:
                return mapChampAdresse(feuille, donnees);
            case FeuilleSoinsChamps.ACCIDENT_CHAMP:
                return mapChampAccident(feuille, donnees);
            case FeuilleSoinsChamps.NOMMALADE_CHAMP:
                return mapChampNomMalade(feuille, donnees);
            case FeuilleSoinsChamps.PRENOMMALADE_CHAMP:
                return mapChampPrenomMalade(feuille, donnees);
            case FeuilleSoinsChamps.DATEDENAISSANCE_CHAMP:
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
            default:
                return feuille;
        }
    }

    private FeuilleSoins mapChampNumeroAM(FeuilleSoins feuille, Object donnees) {
        feuille.setNumeroAM(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampFinValiditeAM(FeuilleSoins feuille, Object donnees) {
        feuille.setFinValiditeAM(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampDebutValiditeAM(FeuilleSoins feuille, Object donnees) {
        feuille.setDebutValiditeAM(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampSituationMalade(FeuilleSoins feuille, Object donnees) {
        feuille.setSituationMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampLienAssure(FeuilleSoins feuille, Object donnees) {
        feuille.setLienAssure(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampDatedenaissance(FeuilleSoins feuille, Object donnees) {
        feuille.setDatedenaissance(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampPrenomMalade(FeuilleSoins feuille, Object donnees) {
        feuille.setPrenomMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNomMalade(FeuilleSoins feuille, Object donnees) {
        feuille.setNomMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampAccident(FeuilleSoins feuille, Object donnees) {
        feuille.setAccident(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampAdresse(FeuilleSoins feuille, Object donnees) {
        feuille.setAdresse(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampPrenomAssure(FeuilleSoins feuille, Object donnees) {
        feuille.setPrenomAssure(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNomAssure(FeuilleSoins feuille, Object donnees) {
        feuille.setNomAssure(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNumeroCafat(FeuilleSoins feuille, Object donnees) {
        feuille.setNumeroCafat(String.valueOf(convertNumberToIntegerString(donnees)));
        return feuille;
    }

    private FeuilleSoins mapChampNomEtPrenomMalade(FeuilleSoins feuille, Object donnees) {
        feuille.setNomEtPrenomMalade(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNumeroACP(FeuilleSoins feuille, Object donnees) {
        feuille.setNumeroACP(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNumeroMedecin(FeuilleSoins feuille, Object donnees) {
        feuille.setNumeroMedecin(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNomMedecin(FeuilleSoins feuille, Object donnees) {
        feuille.setNomMedecin(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampDateOrdonnance(FeuilleSoins feuille, Object donnees) {
        feuille.setDateOrdonnance(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampIdentificationAuxiliaireMedical(FeuilleSoins feuille, Object donnees) {
        feuille.setIdentificationAuxiliaireMedical(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapChampNumeroCompte(FeuilleSoins feuille, Object donnees) {
        feuille.setNumeroCompte(convertToString(donnees));
        return feuille;
    }

    private FeuilleSoins mapReglementNomPrenom(FeuilleSoins feuille, Object donnees) {
        feuille.setReglementNomPrenom(donnees != null ? convertToString(donnees) : "");
        return feuille;
    }

    private FeuilleSoins mapChampNomBanque(FeuilleSoins feuille, Object donnees) {
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
