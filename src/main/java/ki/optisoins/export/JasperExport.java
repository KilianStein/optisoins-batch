package ki.optisoins.export;

import ki.optisoins.utils.PixelUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class JasperExport {
  private static Logger logger = LoggerFactory.getLogger(JasperExport.class);

  public static JasperReport compileReport(JasperDesign jasperDesign) throws JRException {
    logger.trace("Initialisation des paramètres : {}", jasperDesign.getName());
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    logger.trace(" Marge haut : {} px / {} mm",jasperReport.getTopMargin(), PixelUtils.tranformPxToMM(jasperReport.getTopMargin()));
    logger.trace(" Marge gauche : {} px / {} mm", jasperReport.getLeftMargin(), PixelUtils.tranformPxToMM(jasperReport.getLeftMargin()));
    return jasperReport;
  }

  public static JasperDesign initJasperDesign(String jasperReportTemplateUrl) throws JRException {
    return JRXmlLoader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(jasperReportTemplateUrl));
  }
  
  public static JasperPrint fillReport(JasperReport jasperReport, Object obj) throws JRException {
    return JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(Arrays.asList(obj)));
  }
}
