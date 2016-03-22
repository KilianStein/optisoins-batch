package ki.optisoins;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import ki.optisoins.bdd.xls.DossierSoinsXlsMapper;
import ki.optisoins.bdd.xls.FeuilleSoinsXls;
import ki.optisoins.bdd.xls.FeuilleSoinsXlsExtract;
import ki.optisoins.export.dossiersoins.DossierSoinsExport;
import ki.optisoins.gui.AlertUtils;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.pojo.DossierSoins;
import ki.optisoins.process.UpdateDossiersSoinsProcess;
import ki.optisoins.properties.AMOProperties;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.utils.FileUtils;
import ki.optisoins.utils.PropertiesUtils;

/**
 * Classe de lancement du projet ki.optisoins.OptiSoins
 */
public class OptiSoins extends Application {

  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      initRessources();

      List<DossierSoins> dossiersSoins = extractDossiersSoins();
      DossierSoinsExport.exportPDF(dossiersSoins);

      ouvrirDossierOutput();
    } catch (Throwable e) {
      OptiSoinsLogger.printError(e);
      AlertUtils.displayError(e);
    } finally {
      Platform.exit();
    }
  }
  
  private List<DossierSoins> extractDossiersSoins() {
    List<FeuilleSoinsXls> feuilleSoinsXls = new FeuilleSoinsXlsExtract().extract();
    List<DossierSoins> dossiersSoins = new DossierSoinsXlsMapper().map(feuilleSoinsXls);
    return new UpdateDossiersSoinsProcess().process(dossiersSoins);
  }

  private void ouvrirDossierOutput() throws IOException {
    if (Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
      Desktop.getDesktop().open(new File(OptiSoinsConfiguration.outputDirectory));
    }
  }

  private void initRessources() throws IOException {
    initData();
    initOuput();
    PropertiesUtils.printTraceValues(ConfigurationProperties.getProperties(), OptiSoinsConfiguration.fichierConfiguration);
    PropertiesUtils.printTraceValues(AMOProperties.getProperties(), OptiSoinsConfiguration.amoConfiguration);
  }

  private void initOuput() throws IOException {
    try {
      FileUtils.deleteDir(OptiSoinsConfiguration.outputDirectory);
    } catch (IOException e) {
      OptiSoinsLogger.printError("Une erreur est survenue dans la suppression du dossier d'export '" + OptiSoinsConfiguration.outputDirectory + "'", e);
    }
    FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory);
  }

  private void initData() throws IOException {
    initFeuillesSoins();
    initConfiguration();
  }

  private void initConfiguration() throws IOException {
    FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dossierConfiguration);
    FileUtils.copyRessourceIfNotExist(OptiSoinsConfiguration.fichierConfiguration, OptiSoinsConfiguration.fichierConfiguration);
    FileUtils.copyRessourceIfNotExist(OptiSoinsConfiguration.amoConfiguration, OptiSoinsConfiguration.amoConfiguration);
  }

  private void initFeuillesSoins() throws IOException {
    if (FileUtils.isDirEmpty(FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dossierDonnees))) {
      FileUtils.copyRessourceIfNotExist(OptiSoinsConfiguration.donneesDefault, OptiSoinsConfiguration.donneesDefault);
    }
  }
}