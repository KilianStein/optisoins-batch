package ki.optisoins;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Classe de lancement du projet ki.optisoins.OptiSoins
 */
public class OptiSoins {
    public final static boolean AFFICHER_FOND = true;

    public static JasperDesign jasperDesign;
    public static JasperPrint jasperPrint;
    public static JasperReport jasperReport;
    public static String reportTemplateUrl = "FeuilleSoinsAuxiliaireMedicale.jrxml";

    public static void main(String[] args) throws IOException {
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(reportTemplateUrl);
            jasperDesign = JRXmlLoader.load(inputStream);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            for (FeuilleSoins feuilleSoins : findFeuillesSoinsAuxiliaireMedicale()) {
                jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(feuilleSoins)));
                JasperViewer.viewReport(jasperPrint);
                JasperExportManager.exportReportToPdfFile(jasperPrint, "fichiersGeneres/" + feuilleSoins.getNomAssure() + "-" + feuilleSoins.getPrenomAssure() + ".pdf");
            }
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    private static List<FeuilleSoins> findFeuillesSoinsAuxiliaireMedicale() {
        List<FeuilleSoins> feuilleSoins = new XlsExtract().extract();
        new FeuilleSoinsFormat().format(feuilleSoins);
        return feuilleSoins;
    }
}