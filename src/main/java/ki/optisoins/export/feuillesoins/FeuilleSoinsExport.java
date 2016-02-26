package ki.optisoins.export.feuillesoins;

import java.io.File;
import java.util.List;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.export.JasperExport;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.properties.ConfigurationPropertiesValue;
import ki.optisoins.utils.FileUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

public class FeuilleSoinsExport {

  private static JasperReport report = null;

  public static void exportPDF(List<FeuilleSoins> feuillesSoins, String dirName) {
    for (FeuilleSoins feuilleSoins : feuillesSoins) {
      exportPDF(feuilleSoins, dirName);
    }
  }

  public static void exportPDF(FeuilleSoins feuilleSoins, String nomDossier) {
    exportPDF(feuilleSoins, nomDossier, getFileName(feuilleSoins));
  }

  private static void exportPDF(FeuilleSoins feuilleSoins, String nomDossier, String fileName) {
    OptiSoinsLogger.printTrace("export du pdf : '" + nomDossier + File.separator + fileName + "'");
    String pathExportPDF = getPathExportPDF(nomDossier, fileName);
    try {
      JasperExportManager.exportReportToPdfFile(fillReport(feuilleSoins), pathExportPDF);
    } catch (JRException e) {
      OptiSoinsLogger.printError("une erreur est survenue lors de l'export du pdf : '" + pathExportPDF + "'", e);
      throw new RuntimeException(e);
    }
  }

  private static String getFileName(FeuilleSoins feuilleSoins) {
    return feuilleSoins.getAttributsTechnique() != null ? feuilleSoins.getAttributsTechnique().getName() : "";
  }

  public static JasperReport getReport() throws JRException {
    if (report == null) {
      report = compileReport();
    }
    return report;
  }

  private static JasperReport compileReport() throws JRException {
    return JasperExport.compileReport(initJasperDesign());
  }

  private static JasperDesign initJasperDesign() throws JRException {
    JasperDesign jasperDesign = JasperExport.initJasperDesign(OptiSoinsConfiguration.jasperReportFeuilleSoinsTemplateUrl);
    if (ConfigurationProperties.isConfigurationPresente(ConfigurationPropertiesValue.IMPRESSION_MARGE_GAUCHE)) {
      jasperDesign.setLeftMargin(ConfigurationProperties.getMargeGauche());
    }
    if (ConfigurationProperties.isConfigurationPresente(ConfigurationPropertiesValue.IMPRESSION_MARGE_HAUT)) {
      jasperDesign.setTopMargin(ConfigurationProperties.getMargeHaut());
    }
    return jasperDesign;
  }

  private static JasperPrint fillReport(FeuilleSoins feuilleSoins) throws JRException {
    return JasperExport.fillReport(getReport(), new FeuilleSoinsJasperMapper().map(feuilleSoins));
  }

  private static String getPathExportPDF(String nomDossier, String fileName) {
    return getDossierExportPDF(nomDossier)  + File.separator + getFileNamePDF(fileName);
  }

  private static String getFileNamePDF(String fileName) {
    return fileName.replace(" ", "-") + ".pdf";
  }

  private static String getDossierExportPDF(String dirName) {
    return FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory + File.separator + getDossierExcel(dirName)).toString();
  }

  private static String getDossierExcel(String dirName) {
    return ConfigurationProperties.isUnDossierParExcel() ? dirName + File.separator : "";
  }
}
