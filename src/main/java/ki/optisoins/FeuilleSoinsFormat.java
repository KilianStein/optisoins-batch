package ki.optisoins;


import java.util.List;

public class FeuilleSoinsFormat {

    public List<FeuilleSoinsJasper> format(List<FeuilleSoinsJasper> feuillesSoins) {
        for (FeuilleSoinsJasper feuilleSoinsJasper : feuillesSoins){
            format(feuilleSoinsJasper);
        }
        return feuillesSoins;
    }

    private FeuilleSoinsJasper format(FeuilleSoinsJasper feuilleSoinsJasper) {
        formatNumeroCafat(feuilleSoinsJasper);
        formatNumeroCompte(feuilleSoinsJasper);
        return feuilleSoinsJasper;
    }

    private FeuilleSoinsJasper formatNumeroCompte(FeuilleSoinsJasper feuilleSoinsJasper) {
        if (!"".equals(feuilleSoinsJasper.getNumeroCompte())){
            feuilleSoinsJasper.setNumeroCompte(splitSpace(feuilleSoinsJasper.getNumeroCompte(), " "));
        }
        return feuilleSoinsJasper;
    }

    private FeuilleSoinsJasper formatNumeroCafat(FeuilleSoinsJasper feuilleSoinsJasper) {
        if (!"".equals(feuilleSoinsJasper.getNumeroCafat())){
            feuilleSoinsJasper.setNumeroCafat(splitSpace(feuilleSoinsJasper.getNumeroCafat(), "  "));
        }
        return feuilleSoinsJasper;
    }

    private String splitSpace(String s, String space){
        return s.trim().replace(" ", "").replace("", space).trim();
    }

}
