package ki.optisoins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Représente les actes d'une feuille de soin.
 */
public class Actes {

    public static final int NOMBRE_ACTES_PAR_FEUILLE_DE_SOINS = 11;

    private List<Acte> actes = new ArrayList<>(NOMBRE_ACTES_PAR_FEUILLE_DE_SOINS - 1);

    public Actes(){
        for(int i = 0; i < NOMBRE_ACTES_PAR_FEUILLE_DE_SOINS; i++){
            actes.add(null);
        }
    }

    public int calculerTotal() {
        int total = 0;
        for (Acte acte : actes) {
            if (acte != null){
                total += acte.getTotal();
            }
        }
        return total;
    }

    public void setToActes(int numeroLigne, Acte acte){
        actes.set(numeroLigne - 1, acte);
    }

    public Acte getActe(int numeroLigne){
        return actes.get(numeroLigne-1);
    }

}
