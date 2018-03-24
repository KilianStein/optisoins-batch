package ki.optisoins;

public class OptiSoinsConfiguration {
  public static String jasperReportFeuilleSoinsTemplateUrl = "jasper/feuillesoins/{0}/FeuilleSoinsAuxiliaireMedicale.jrxml";
  public static String jasperReportEtat100TemplateUrl = "jasper/etat_100/Etat_100.jrxml";
  public static String jasperReportEtatAideMedicalSudTemplateUrl = "jasper/etat_aidemedicale_sud/Etat_AideMedicale_Sud.jrxml";
  public static String jasperReportEtatAideMedicalNordTemplateUrl = "jasper/etat_aidemedicale_nord/Etat_AideMedicale_Nord.jrxml";
  public static String jasperReportEtatAideMedicalIlesTemplateUrl = "jasper/etat_aidemedicale_iles/Etat_AideMedicale_Iles.jrxml";

  public static String outputDirectory = "fichiersGeneres";

  public static String dossierDonnees = "donnees";
  public static String donneesDefault = dossierDonnees + "/FeuillesSoins.xls";
  public static String dossierConfiguration = "conf";

  public static String fichierConfiguration = dossierConfiguration + "/optisoins.conf";
  public static String amoConfiguration = dossierConfiguration + "/amo.conf";
}
