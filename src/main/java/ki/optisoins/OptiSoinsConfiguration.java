package ki.optisoins;

public class OptiSoinsConfiguration {
  public static String jasperReportFeuilleSoinsTemplateUrl = "jasper/feuillesoins/FeuilleSoinsAuxiliaireMedicale.jrxml";
  public static String jasperReportEtat100TemplateUrl = "jasper/etat_100/Etat_100.jrxml";
  public static String jasperReportEtatAideMedicalSudTemplateUrl = "jasper/etat_aidemedicale_sud/Etat_AideMedicale_Sud.jrxml";

  public static String outputDirectory = "fichiersGeneres";

  public static String dossierDonnees = "donnees";
  public static String donneesDefault = dossierDonnees + "/FeuillesSoins.xls";
  public static String dossierConfiguration = "conf";

  public static String fichierConfiguration = dossierConfiguration + "/optisoins.conf";
  public static String amoConfiguration = dossierConfiguration + "/amo.conf";
}
