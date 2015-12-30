package ki.optisoins;


import org.apache.commons.lang.StringUtils;

public class JasperUtils {

    public static final String ACTE_DEFAULT_FORMAT = " ; ; ; ; ; ; ; ; ";

    public static String toJasperFormat(Acte acte){
        if (acte == null) {
            return ACTE_DEFAULT_FORMAT;
        }
        String[] s = new String[9];
        s[0] = formatActeAttribute(acte.getDate());
        s[1] = formatActeAttribute(acte.getOrigine());
        s[2] = formatAMO(acte.getAmo());
        s[3] = formatActeAttribute(acte.getMontantHonoraire());
        s[4] = formatActeAttribute(acte.getFraisDeplacement());
        s[5] = " ";
        s[6] = " ";
        s[7] = formatActeAttribute(acte.getTicketModerateur());
        s[8] = formatActeAttribute(acte.getTotal());
        return  StringUtils.join(s, ";");
    }

    public static Acte createActe(String sJasperFormat){
        String[] s = sJasperFormat.split(";");
        Acte acte = new Acte();
        acte.setDate(s[0]);
        if (s.length>1){
            acte.setOrigine(s[1]);
            if (s.length>2){
            	acte.setAmo(s[2]);
            }
            if (s.length>3){
            	acte.setFraisDeplacement(Integer.parseInt(s[3]));
            }
            if (s.length>4){
            	acte.setTicketModerateur(s[4]);
            }
        }
        return  acte;
    }

    private static String formatAMO(String s){
        return s == null || "".equals(s) ? " " : "AMO " + s;
    }
    
    private static String formatActeAttribute(String s){
        return s == null || "".equals(s) ? " " : s;
    }

    private static String formatActeAttribute(int i){
        return i == 0 ? " " : String.valueOf(i);
    }

    public static String formatAttribute(int i){
        return i == 0 ? "" : String.valueOf(i);
    }

    public static String formatXPF(String montant){
        return montant == null || "".equals(montant) ? "" : montant + " XPF";
    }
}
