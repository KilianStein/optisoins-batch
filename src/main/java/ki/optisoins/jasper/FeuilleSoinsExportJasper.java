package ki.optisoins.jasper;

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
import java.io.IOException;
import java.util.Arrays;

public class FeuilleSoinsExportJasper {

  public static JasperPrint fillReport(JasperReport jasperReport, FeuilleSoinsJasper feuilleSoinsJasper) throws JRException {
    return JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(feuilleSoinsJasper)));
  }

  public static JasperReport compileReport() throws JRException {
    OptiSoinsLogger.printTrace("Initialisation des paramètres la feuille de soins");
    JasperReport jasperReport = JasperCompileManager.compileReport(initJasperDesign());
    OptiSoinsLogger.printTrace(" Marge haut : " + jasperReport.getTopMargin() + "px / " + PixelUtils.tranformPxToMM(jasperReport.getTopMargin()) + " mm");
    OptiSoinsLogger.printTrace(" Marge gauche : " + jasperReport.getLeftMargin() + "px / " + PixelUtils.tranformPxToMM(jasperReport.getLeftMargin()) + " mm");
    return jasperReport;
  }

  private static JasperDesign initJasperDesign() throws JRException {
    JasperDesign jasperDesign = JRXmlLoader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(OptiSoinsConfiguration.reportTemplateUrl));
    if (ConfigurationProperties.isConfigurationPresente(ConfigurationPropertiesValue.IMPRESSION_MARGE_GAUCHE)) {
      jasperDesign.setLeftMargin(ConfigurationProperties.getMargeGauche());
    }

    if (ConfigurationProperties.isConfigurationPresente(ConfigurationPropertiesValue.IMPRESSION_MARGE_HAUT)) {
      jasperDesign.setTopMargin(ConfigurationProperties.getMargeHaut());
    }
    return jasperDesign;
  }

  public static void printReport(JasperReport jasperReport, FeuilleSoins feuilleSoins) throws JRException, IOException {
    FeuilleSoinsJasper feuilleSoinsJasper = new FeuilleSoinsJasperMapper().map(feuilleSoins);
    JasperPrint jasperPrint = FeuilleSoinsExportJasper.fillReport(jasperReport, feuilleSoinsJasper);

    //JasperViewer.viewReport(jasperPrint);
    //JasperPrintManager.printReport(jasperPrint, false);
    exportReportToPdfFile(jasperPrint, getPathExportPDF(feuilleSoins, feuilleSoinsJasper));
  }

  private static void exportReportToPdfFile(JasperPrint jasperPrint, String pathExportPDF) throws JRException {
    OptiSoinsLogger.printTrace("export du pdf : '" + pathExportPDF + "'");
    try {
      JasperExportManager.exportReportToPdfFile(jasperPrint, pathExportPDF);
    } catch (JRException e) {
      OptiSoinsLogger.printError("une erreur est survenue lors de l'export du pdf : '" + pathExportPDF + "'", e);
      throw e;
    }
  }

  private static String getPathExportPDF(FeuilleSoins feuilleSoins, FeuilleSoinsJasper feuilleSoinsJasper) throws IOException {
    return getDossierExportPDF(feuilleSoins) + getFileNamePDF(feuilleSoinsJasper);
  }

  private static String getFileNamePDF(FeuilleSoinsJasper feuilleSoinsJasper) {
    return feuilleSoinsJasper.getNomEtPrenomMalade().replace(" ", "-") + ".pdf";
  }

  private static String getDossierExportPDF(FeuilleSoins feuilleSoins) throws IOException {
    return FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory + File.separator + getDossierExcel(feuilleSoins)) + File.separator;
  }

  private static String getDossierExcel(FeuilleSoins feuilleSoins) {
    if (ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.UN_DOSSIER_PAR_EXCEL)) {
      return feuilleSoins.getAttributsTechnique().getDossierExport();
    }
    return "";
  }
}
