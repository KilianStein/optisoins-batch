package ki.optisoins.jasper;


import ki.optisoins.jasper.FeuilleSoinsJasper;
import ki.optisoins.jasper.JasperUtils;

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
        formatNomEtPrenomMalade(feuilleSoinsJasper);
        formatNumeroCompte(feuilleSoinsJasper);
        formatActes(feuilleSoinsJasper);
        formatTotal(feuilleSoinsJasper);
        return feuilleSoinsJasper;
    }

    private void formatNomEtPrenomMalade(FeuilleSoinsJasper feuilleSoinsJasper) {
    	String nomEtPrenomMalade = feuilleSoinsJasper.getNomEtPrenomMalade();
    	if ("".equals(nomEtPrenomMalade.trim())){
    		nomEtPrenomMalade = feuilleSoinsJasper.getNomMalade() + " " + feuilleSoinsJasper.getPrenomMalade();
    	}
    	if ("".equals(nomEtPrenomMalade.trim())){
    		nomEtPrenomMalade = feuilleSoinsJasper.getNomAssure() + " " + feuilleSoinsJasper.getPrenomAssure();
    	}
		feuilleSoinsJasper.setNomEtPrenomMalade(nomEtPrenomMalade);
	}

	private void formatTotal(FeuilleSoinsJasper feuilleSoinsJasper) {
        feuilleSoinsJasper.setTotal(JasperUtils.formatXPF(JasperUtils.formatAttribute(feuilleSoinsJasper.calculerTotal())));
    }

    private void formatActes(FeuilleSoinsJasper feuilleSoinsJasper) {
    	feuilleSoinsJasper.updateActes();
        feuilleSoinsJasper.setActe1(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(1)));
        feuilleSoinsJasper.setActe2(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(2)));
        feuilleSoinsJasper.setActe3(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(3)));
        feuilleSoinsJasper.setActe4(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(4)));
        feuilleSoinsJasper.setActe5(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(5)));
        feuilleSoinsJasper.setActe6(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(6)));
        feuilleSoinsJasper.setActe7(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(7)));
        feuilleSoinsJasper.setActe8(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(8)));
        feuilleSoinsJasper.setActe9(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(9)));
        feuilleSoinsJasper.setActe10(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(10)));
        feuilleSoinsJasper.setActe11(JasperUtils.toJasperFormat(feuilleSoinsJasper.getActe(11)));
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
