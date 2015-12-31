package ki.optisoins;

import ki.optisoins.jasper.FeuilleSoinsExportJasper;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.mapper.xls.FeuilleSoinsXls;
import ki.optisoins.mapper.xls.FeuilleSoinsXlsExtract;
import ki.optisoins.mapper.xls.FeuilleSoinsXlsMapper;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.properties.AMOProperties;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.utils.FileUtils;
import ki.optisoins.utils.PropertiesUtils;
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
      JasperReport jasperReport = FeuilleSoinsExportJasper.compileReport();
      for (FeuilleSoins feuilleSoins : findFeuillesSoins()) {
        FeuilleSoinsExportJasper.printReport(jasperReport, feuilleSoins);
      }
    } catch (Throwable e) {
      OptiSoinsLogger.printError(e);
      throw e;
    }
  }

  private static List<FeuilleSoins> findFeuillesSoins() {
    List<FeuilleSoinsXls> feuilleSoinsXls = new FeuilleSoinsXlsExtract().extract();
    return new FeuilleSoinsXlsMapper().map(feuilleSoinsXls);
  }

  private static void initRessources() throws IOException {
    PropertiesUtils.printTraceValues(ConfigurationProperties.getProperties(), OptiSoinsConfiguration.fichierConfiguration);
    PropertiesUtils.printTraceValues(AMOProperties.getProperties(), OptiSoinsConfiguration.amoConfiguration);
    initData();
    initOuput();
  }

  private static void initOuput() throws IOException {
    try {
      FileUtils.deleteDir(OptiSoinsConfiguration.outputDirectory);
    } catch (IOException e) {
      OptiSoinsLogger.printError("Une erreur est survenue dans la suppression du dossier d'export '" + OptiSoinsConfiguration.outputDirectory + "'", e);
    }
    FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory);
  }

  private static void initData() throws IOException {
    FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dataDirectory);
  }
}
