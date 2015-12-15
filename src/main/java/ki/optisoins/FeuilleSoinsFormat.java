package ki.optisoins;


import java.util.List;

public class FeuilleSoinsFormat {

    public List<FeuilleSoins> format(List<FeuilleSoins> feuillesSoins) {
        for (FeuilleSoins feuilleSoins : feuillesSoins){
            format(feuilleSoins);
        }
        return feuillesSoins;
    }

    private FeuilleSoins format(FeuilleSoins feuilleSoins) {
        formatNumeroCafat(feuilleSoins);
        formatNumeroCompte(feuilleSoins);
        return feuilleSoins;
    }

    private FeuilleSoins formatNumeroCompte(FeuilleSoins feuilleSoins) {
        if (!"".equals(feuilleSoins.getNumeroCompte())){
            feuilleSoins.setNumeroCompte(splitSpace(feuilleSoins.getNumeroCompte(), " "));
        }
        return feuilleSoins;
    }

    private FeuilleSoins formatNumeroCafat(FeuilleSoins feuilleSoins) {
        if (!"".equals(feuilleSoins.getNumeroCafat())){
            feuilleSoins.setNumeroCafat(splitSpace(feuilleSoins.getNumeroCafat(), "  "));
        }
        return feuilleSoins;
    }

    private String splitSpace(String s, String space){
        return s.trim().replace(" ", "").replace("", space).trim();
    }

}
