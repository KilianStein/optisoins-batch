package ki.optisoins.export.etat;

import java.io.File;
import java.util.List;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.export.JasperExport;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.pojo.Etat;
import ki.optisoins.properties.ConfigurationProperties;
import ki.optisoins.properties.ConfigurationPropertiesValue;
import ki.optisoins.utils.FileUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

public class EtatExport {
  
  private static JasperReport report = null;

  public static void exportPDF(List<Etat> etats, String nomDossier) {
    for (Etat etat : etats){
      exportPDF(etat, nomDossier);
    }
  }

  private static void exportPDF(Etat etat, String nomDossier) {
    exportPDF(etat, nomDossier, getFileName(nomDossier, etat));
  }
  
  private static void exportPDF(Etat etat, String nomDossier, String fileName) {
    OptiSoinsLogger.printTrace("export du pdf : '" + nomDossier + File.separator + fileName + "'");
    String pathExportPDF = getPathExportPDF(nomDossier, fileName);
    try {
      JasperExportManager.exportReportToPdfFile(fillReport(etat), pathExportPDF);
    } catch (JRException e) {
      OptiSoinsLogger.printError("une erreur est survenue lors de l'export du pdf : '" + pathExportPDF + "'", e);
      throw new RuntimeException(e);
    }
  }

  private static String getFileName(String nomDossier, Etat etat) {
    String prefixe = ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.UN_DOSSIER_PAR_EXCEL) ? "" : "_" + nomDossier ;
    return prefixe + "_etat-n-" + etat.getNumero();
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
    return JasperExport.initJasperDesign(OptiSoinsConfiguration.jasperReportEtatTemplateUrl);
  }

  private static JasperPrint fillReport(Etat etat) throws JRException {
    return JasperExport.fillReport(getReport(), new EtatJasperMapper().map(etat));
  }
}
