package ki.optisoins;

import net.sf.jasperreports.engine.JasperReport;

import java.io.IOException;
import java.util.List;


/**
 * Classe de lancement du projet ki.optisoins.OptiSoins
 */
public class OptiSoins {
    public final static boolean AFFICHER_FOND = false;


    public static void main(String[] args) throws IOException {
        try {
            initRessources();
            JasperReport jasperReport = OptiSoinsJasper.compileReport();
            for (FeuilleSoins feuilleSoins : findFeuillesSoinsAuxiliaireMedicale()) {
                OptiSoinsJasper.printReport(jasperReport, feuilleSoins);
            }
        } catch (Throwable e) {
            OptiSoinsLogger.printError(e);
        }
    }

    private static List<FeuilleSoins> findFeuillesSoinsAuxiliaireMedicale() {
        List<FeuilleSoins> feuilleSoins = new XlsExtract().extract();
        new FeuilleSoinsFormat().format(feuilleSoins);
        return feuilleSoins;
    }

    private static void initRessources() throws IOException {
        initData();
        initOuput();
        OptiSoinsProperties.initProperties();
        OptiSoinsLogger.initLogger();
    }

    private static void initOuput() throws IOException {
        FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory);
    }

    private static void initData() throws IOException {
        FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dataDirectory);
    }


}
