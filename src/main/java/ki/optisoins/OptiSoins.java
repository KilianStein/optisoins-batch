package ki.optisoins;

import ki.optisoins.jasper.FeuilleSoinsFormat;
import ki.optisoins.jasper.FeuilleSoinsJasper;
import ki.optisoins.jasper.OptiSoinsJasper;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.mapper.xls.XlsExtract;
import ki.optisoins.properties.AMOProperties;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.utils.FileUtils;
import net.sf.jasperreports.engine.JasperReport;

import java.io.IOException;
import java.util.List;


/**
 * Classe de lancement du projet ki.optisoins.OptiSoins
 */
public class OptiSoins {

    public static void main(String[] args) throws Exception {
        try {
            initRessources();
            JasperReport jasperReport = OptiSoinsJasper.compileReport();
            for (FeuilleSoinsJasper feuilleSoinsJasper : findFeuillesSoinsAuxiliaireMedicale()) {
                OptiSoinsJasper.printReport(jasperReport, feuilleSoinsJasper);
            }
        } catch (Throwable e) {
            OptiSoinsLogger.printError(e);
            throw e;
        }
    }

    private static List<FeuilleSoinsJasper> findFeuillesSoinsAuxiliaireMedicale() {
        List<FeuilleSoinsJasper> feuilleSoinJaspers = new XlsExtract().extract();
        new FeuilleSoinsFormat().format(feuilleSoinJaspers);
        return feuilleSoinJaspers;
    }

    private static void initRessources() throws IOException {
        initData();
        initOuput();
        AMOProperties.initProperties();
    }

    private static void initOuput() throws IOException {
        FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory);
    }

    private static void initData() throws IOException {
        FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dataDirectory);
    }


}
