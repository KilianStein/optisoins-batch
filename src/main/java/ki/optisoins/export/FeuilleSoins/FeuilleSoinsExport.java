package ki.optisoins.export.feuilleSoins;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.pojo.FeuilleSoins;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.properties.ConfigurationPropertiesValue;
import ki.optisoins.utils.FileUtils;
import ki.optisoins.utils.PixelUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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
    OptiSoinsLogger.printTrace("Initialisation des paramètres la feuille de soins");
    JasperReport jasperReport = JasperCompileManager.compileReport(initJasperDesign());
    OptiSoinsLogger.printTrace(" Marge haut : " + jasperReport.getTopMargin() + "px / " + PixelUtils.tranformPxToMM(jasperReport.getTopMargin()) + " mm");
    OptiSoinsLogger.printTrace(" Marge gauche : " + jasperReport.getLeftMargin() + "px / " + PixelUtils.tranformPxToMM(jasperReport.getLeftMargin()) + " mm");
    return jasperReport;
  }

  private static JasperDesign initJasperDesign() throws JRException {
    JasperDesign jasperDesign = JRXmlLoader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(OptiSoinsConfiguration.jasperReportFeuilleSoinsTemplateUrl));
    if (ConfigurationProperties.isConfigurationPresente(ConfigurationPropertiesValue.IMPRESSION_MARGE_GAUCHE)) {
      jasperDesign.setLeftMargin(ConfigurationProperties.getMargeGauche());
    }

    if (ConfigurationProperties.isConfigurationPresente(ConfigurationPropertiesValue.IMPRESSION_MARGE_HAUT)) {
      jasperDesign.setTopMargin(ConfigurationProperties.getMargeHaut());
    }
    return jasperDesign;
  }

  private static JasperPrint fillReport(FeuilleSoins feuilleSoins) throws JRException {
    return JasperFillManager.fillReport(getReport(), null, new JRBeanCollectionDataSource(Arrays.asList(new FeuilleSoinsJasperMapper().map(feuilleSoins))));
  }

  private static String getPathExportPDF(String nomDossier, String fileName) {
    return getDossierExportPDF(nomDossier) + getFileNamePDF(fileName);
  }

  private static String getFileNamePDF(String fileName) {
    return fileName.replace(" ", "-") + ".pdf";
  }

  private static String getDossierExportPDF(String dirName) {
    return FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory + File.separator + getDossierExcel(dirName));
  }

  private static String getDossierExcel(String dirName) {
    return ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.UN_DOSSIER_PAR_EXCEL) ? dirName + File.separator : "";
  }
}
