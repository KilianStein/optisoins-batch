package ki.optisoins;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class OptiSoinsJasper {

    public static JasperPrint fillReport(JasperReport jasperReport, FeuilleSoinsJasper feuilleSoinsJasper) throws JRException {
        return JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(feuilleSoinsJasper)));
    }

    public static JasperReport compileReport() throws JRException {
        return JasperCompileManager.compileReport(initJasperDesign());
    }

    private static JasperDesign initJasperDesign() throws JRException {
        JasperDesign jasperDesign = JRXmlLoader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(OptiSoinsConfiguration.reportTemplateUrl));
        if (OptiSoinsProperties.isConfigurationPresente(OptiSoinsPropertiesValue.IMPRESSION_MARGE_GAUCHE)) {
            jasperDesign.setLeftMargin(OptiSoinsProperties.getConfigurationInteger(OptiSoinsPropertiesValue.IMPRESSION_MARGE_GAUCHE));
        }

        if (OptiSoinsProperties.isConfigurationPresente(OptiSoinsPropertiesValue.IMPRESSION_MARGE_HAUT)) {
            jasperDesign.setTopMargin(OptiSoinsProperties.getConfigurationInteger(OptiSoinsPropertiesValue.IMPRESSION_MARGE_HAUT));
        }
        return jasperDesign;
    }


    public static void printReport(JasperReport jasperReport, FeuilleSoinsJasper feuilleSoinsJasper) throws JRException, IOException {
        JasperPrint jasperPrint = OptiSoinsJasper.fillReport(jasperReport, feuilleSoinsJasper);

        JasperExportManager.exportReportToPdfFile(jasperPrint, getPathExportPDF(feuilleSoinsJasper));
        //JasperViewer.viewReport(jasperPrint);
        //JasperPrintManager.printReport(jasperPrint, false);
    }

    private static String getPathExportPDF(FeuilleSoinsJasper feuilleSoinsJasper) throws IOException {
        return getDossierExportPDF(feuilleSoinsJasper) + getFileNamePDF(feuilleSoinsJasper);
    }

    private static String getFileNamePDF(FeuilleSoinsJasper feuilleSoinsJasper) {
        return feuilleSoinsJasper.getNomEtPrenomMalade().replace(" ", "-") + ".pdf";
    }

    private static String getDossierExportPDF(FeuilleSoinsJasper feuilleSoinsJasper) throws IOException {
        return FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory + File.separator + getDossierExcel(feuilleSoinsJasper)) + File.separator;
    }

    private static String getDossierExcel(FeuilleSoinsJasper feuilleSoinsJasper) {
        if (OptiSoinsProperties.getConfigurationBoolean(OptiSoinsPropertiesValue.UN_DOSSIER_PAR_EXCEL)) {
            return feuilleSoinsJasper.getNomDossier();
        }
        return "";
    }
}
