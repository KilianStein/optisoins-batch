package ki.optisoins;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import ki.optisoins.bdd.xls.DossierSoinsXlsMapper;
import ki.optisoins.bdd.xls.FeuilleSoinsXls;
import ki.optisoins.bdd.xls.FeuilleSoinsXlsExtract;
import ki.optisoins.export.dossiersoins.DossierSoinsExport;
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
public class OptiSoins {

  public static void main(String[] args) throws Exception {
    try {
      initRessources();

      List<DossierSoins> dossiersSoins = extractDossiersSoins();
      DossierSoinsExport.exportPDF(dossiersSoins);

      ouvrirDossierOutput();
    } catch (Throwable e) {
      OptiSoinsLogger.printError(e);
      displayError(e);
      throw e;
    }
  }

  private static void displayError(Throwable e) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur dans l'application");
    alert.setHeaderText("Oh oh, il y a eu un problème...");
    alert.setContentText(e.getMessage());

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    e.printStackTrace(pw);
    String exceptionText = sw.toString();

    Label label = new Label("La trace d'erreur est la suivante :");

    TextArea textArea = new TextArea(exceptionText);
    textArea.setEditable(false);
    textArea.setWrapText(true);

    textArea.setMaxWidth(Double.MAX_VALUE);
    textArea.setMaxHeight(Double.MAX_VALUE);
    GridPane.setVgrow(textArea, Priority.ALWAYS);
    GridPane.setHgrow(textArea, Priority.ALWAYS);

    GridPane expContent = new GridPane();
    expContent.setMaxWidth(Double.MAX_VALUE);
    expContent.add(label, 0, 0);
    expContent.add(textArea, 0, 1);

    alert.getDialogPane().setExpandableContent(expContent);

    alert.showAndWait();
  }

  private static List<DossierSoins> extractDossiersSoins() {
    List<FeuilleSoinsXls> feuilleSoinsXls = new FeuilleSoinsXlsExtract().extract();
    List<DossierSoins> dossiersSoins = new DossierSoinsXlsMapper().map(feuilleSoinsXls);
    return new UpdateDossiersSoinsProcess().process(dossiersSoins);
  }

  private static void ouvrirDossierOutput() throws IOException {
    if (Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
      Desktop.getDesktop().open(new File(OptiSoinsConfiguration.outputDirectory));
    }
  }

  private static void initRessources() throws IOException {
    initData();
    initOuput();
    PropertiesUtils.printTraceValues(ConfigurationProperties.getProperties(), OptiSoinsConfiguration.fichierConfiguration);
    PropertiesUtils.printTraceValues(AMOProperties.getProperties(), OptiSoinsConfiguration.amoConfiguration);
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
    initFeuillesSoins();
    initConfiguration();
  }

  private static void initConfiguration() throws IOException {
    FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dossierConfiguration);
    FileUtils.copyRessourceIfNotExist(OptiSoinsConfiguration.fichierConfiguration, OptiSoinsConfiguration.fichierConfiguration);
    FileUtils.copyRessourceIfNotExist(OptiSoinsConfiguration.amoConfiguration, OptiSoinsConfiguration.amoConfiguration);
  }

  private static void initFeuillesSoins() throws IOException {
    if (FileUtils.isDirEmpty(FileUtils.createDirIfNotExist(OptiSoinsConfiguration.dossierDonnees))) {
      FileUtils.copyRessourceIfNotExist(OptiSoinsConfiguration.donneesDefault, OptiSoinsConfiguration.donneesDefault);
    }
  }
}