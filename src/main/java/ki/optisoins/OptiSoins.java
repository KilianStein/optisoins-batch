package ki.optisoins;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 * Classe de lancement du projet ki.optisoins.OptiSoins
 */
public class OptiSoins {
    public static JasperDesign jasperDesign;
    public static JasperPrint jasperPrint;
    public static JasperReport jasperReport;
    public static String reportTemplateUrl = "src/main/resources/FeuilleSoinsAuxiliaireMedicale.jrxml";

    public static void main(String[] args) throws IOException {
        try {
            InputStream resourceAsStream = new FileInputStream(reportTemplateUrl);
            jasperDesign = JRXmlLoader.load(resourceAsStream);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(findFeuillesSoinsAuxiliaireMedicale()));
            JasperViewer.viewReport(jasperPrint);
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "classic.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
    private static Collection findFeuillesSoinsAuxiliaireMedicale(){
        List<FeuilleSoins> feuilleSoins = new XlsExtract().extract();
        new FeuilleSoinsFormat().format(feuilleSoins);
        return feuilleSoins;
    }
}
