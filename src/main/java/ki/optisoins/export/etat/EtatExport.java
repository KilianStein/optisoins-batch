package ki.optisoins.export.etat;

import java.io.File;
import java.util.List;

import ki.optisoins.OptiSoinsConfiguration;
import ki.optisoins.export.JasperExport;
import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.pojo.Etat;
import ki.optisoins.pojo.LocalisationAM;
import ki.optisoins.pojo.PriseEnCharge;
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
    for (Etat etat : etats) {
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
    String prefixe = ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.UN_DOSSIER_PAR_EXCEL) ? "" : "_" + nomDossier;
    return prefixe + "_etat-n-" + etat.getNumero();
  }

  private static String getPathExportPDF(String nomDossier, String fileName) {
    return getDossierExportPDF(nomDossier) + File.separator + getFileNamePDF(fileName);
  }

  private static String getFileNamePDF(String fileName) {
    return fileName.replace(" ", "-") + ".pdf";
  }

  private static String getDossierExportPDF(String dirName) {
    return FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory + File.separator + getDossierExcel(dirName)).toString();
  }

  private static String getDossierExcel(String dirName) {
    return ConfigurationProperties.getConfigurationBoolean(ConfigurationPropertiesValue.UN_DOSSIER_PAR_EXCEL) ? dirName + File.separator : "";
  }

  public static JasperReport getReport(Etat etat) throws JRException {
    return compileReport(etat);
  }

  private static JasperReport compileReport(Etat etat) throws JRException {
    return JasperExport.compileReport(initJasperDesign(etat));
  }

  private static JasperDesign initJasperDesign(Etat etat) throws JRException {
    if (PriseEnCharge.REMBOURSEMENT_100_POURCENT.equals(etat.getPriseEnCharge())) {
      return JasperExport.initJasperDesign(OptiSoinsConfiguration.jasperReportEtat100TemplateUrl);
    } else if (PriseEnCharge.AIDE_MEDICALE.equals(etat.getPriseEnCharge()) && LocalisationAM.SUD.equals(etat.getLocalisationAM())) {
      return JasperExport.initJasperDesign(OptiSoinsConfiguration.jasperReportEtatAideMedicalSudTemplateUrl);
    }
    throw new RuntimeException("La génération pour l'état numéro : '" + etat.getNumero() + "' n'est pas géré");
  }

  private static JasperPrint fillReport(Etat etat) throws JRException {
    return JasperExport.fillReport(getReport(etat), new EtatJasperMapper().map(etat));
  }
}
