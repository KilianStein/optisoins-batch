package ki.optisoins;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * Classe de lancement du projet ki.optisoins.OptiSoins
 */
public class OptiSoins {
    public final static boolean AFFICHER_FOND = false;

    public static JasperDesign jasperDesign;
    public static JasperPrint jasperPrint;
    public static JasperReport jasperReport;


    public static void main(String[] args) throws IOException {
    	initRessources();
    	
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(OptiSoinsConfiguration.reportTemplateUrl);
            OptiSoinsProperties.initProperties();
            jasperDesign = JRXmlLoader.load(inputStream);
            if (OptiSoinsProperties.isConfigurationPresente(OptiSoinsPropertiesValue.IMPRESSION_MARGE_GAUCHE)){
                jasperDesign.setLeftMargin(OptiSoinsProperties.getConfigurationInteger(OptiSoinsPropertiesValue.IMPRESSION_MARGE_GAUCHE));
            }

            if (OptiSoinsProperties.isConfigurationPresente(OptiSoinsPropertiesValue.IMPRESSION_MARGE_HAUT)){
                jasperDesign.setTopMargin(OptiSoinsProperties.getConfigurationInteger(OptiSoinsPropertiesValue.IMPRESSION_MARGE_HAUT));
            }

            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            for (FeuilleSoins feuilleSoins : findFeuillesSoinsAuxiliaireMedicale()) {
                    jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(feuilleSoins)));
                    //JasperViewer.viewReport(jasperPrint);
                    JasperExportManager.exportReportToPdfFile(jasperPrint, createDirIfNotExist("fichiersGeneres/" + getDossierExcel(feuilleSoins)) + File.separator + feuilleSoins.getNomEtPrenomMalade().replace(" ", "-") + ".pdf");
                    //JasperPrintManager.printReport(jasperPrint, false);
            }
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    private static String getDossierExcel(FeuilleSoins feuilleSoins) {
        if (OptiSoinsProperties.getConfigurationBoolean(OptiSoinsPropertiesValue.UN_DOSSIER_PAR_EXCEL)){
            return feuilleSoins.getNomDossier();
        }
        return "";
    }


    private static List<FeuilleSoins> findFeuillesSoinsAuxiliaireMedicale() {
        List<FeuilleSoins> feuilleSoins = new XlsExtract().extract();
        new FeuilleSoinsFormat().format(feuilleSoins);
        return feuilleSoins;
    }
    
    private static void initRessources() throws IOException {
    	initData();
    	initOuput();
	}

	private static void initOuput() throws IOException {
		createDirIfNotExist(OptiSoinsConfiguration.outputDirectory);
	}
	
	private static String createDirIfNotExist(String dir) throws IOException {
		Path path = Paths.get(dir);
		if(!Files.isReadable(path) || !Files.isDirectory(path)){
			Files.createDirectory(path);
		}
        return dir;
	}

	private static void initData() throws IOException {
		createDirIfNotExist(OptiSoinsConfiguration.dataDirectory);
	}
	


}
