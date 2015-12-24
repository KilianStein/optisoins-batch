package ki.optisoins;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class OptiSoinsJasper {

    public static JasperPrint fillReport(JasperReport jasperReport, FeuilleSoins feuilleSoins) throws JRException {
        return JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(feuilleSoins)));
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


    public static void printReport(JasperReport jasperReport, FeuilleSoins feuilleSoins) throws JRException, IOException {
        JasperPrint jasperPrint = OptiSoinsJasper.fillReport(jasperReport, feuilleSoins);

        JasperExportManager.exportReportToPdfFile(jasperPrint, getPathExportPDF(feuilleSoins));
        //JasperViewer.viewReport(jasperPrint);
        //JasperPrintManager.printReport(jasperPrint, false);
    }

    private static String getPathExportPDF(FeuilleSoins feuilleSoins) throws IOException {
        return getDossierExportPDF(feuilleSoins) + getFileNamePDF(feuilleSoins);
    }

    private static String getFileNamePDF(FeuilleSoins feuilleSoins) {
        return feuilleSoins.getNomEtPrenomMalade().replace(" ", "-") + ".pdf";
    }

    private static String getDossierExportPDF(FeuilleSoins feuilleSoins) throws IOException {
        return FileUtils.createDirIfNotExist(OptiSoinsConfiguration.outputDirectory + File.separator + getDossierExcel(feuilleSoins)) + File.separator;
    }

    private static String getDossierExcel(FeuilleSoins feuilleSoins) {
        if (OptiSoinsProperties.getConfigurationBoolean(OptiSoinsPropertiesValue.UN_DOSSIER_PAR_EXCEL)) {
            return feuilleSoins.getNomDossier();
        }
        return "";
    }
}
