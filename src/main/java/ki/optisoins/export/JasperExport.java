package ki.optisoins.export;

import java.util.Arrays;

import ki.optisoins.log.OptiSoinsLogger;
import ki.optisoins.utils.PixelUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class JasperExport {

  public static JasperReport compileReport(JasperDesign jasperDesign) throws JRException {
    OptiSoinsLogger.printTrace("Initialisation des paramètres : " + jasperDesign.getName());
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    OptiSoinsLogger.printTrace(" Marge haut : " + jasperReport.getTopMargin() + "px / " + PixelUtils.tranformPxToMM(jasperReport.getTopMargin()) + " mm");
    OptiSoinsLogger.printTrace(" Marge gauche : " + jasperReport.getLeftMargin() + "px / " + PixelUtils.tranformPxToMM(jasperReport.getLeftMargin()) + " mm");
    return jasperReport;
  }

  public static JasperDesign initJasperDesign(String jasperReportTemplateUrl) throws JRException {
    return JRXmlLoader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(jasperReportTemplateUrl));
  }
  
  public static JasperPrint fillReport(JasperReport jasperReport, Object obj) throws JRException {
    return JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(obj)));
  }
}
