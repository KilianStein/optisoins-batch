package ki.optisoins.export.etat;

public class EtatJasper {

  private String numero = "";
  private String date = "";

  private String feuilleSoins1 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins2 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins3 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins4 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins5 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins6 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins7 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins8 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins9 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins10 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins11 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins12 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins13 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins14 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins15 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins16 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins17 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins18 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins19 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;
  private String feuilleSoins20 = EtatJasperFormat.FEUILLE_SOINS_DEFAULT_FORMAT;

  private String totalActesEtDeplacements = "";
  private String montantAbattement = "";
  private String montantAPayer = "";

  public void setFeuilleSoins(int i, String feuilleChaineFormat) {
    switch (i) {
      case 1:
        setFeuilleSoins1(feuilleChaineFormat);
        break;
      case 2:
        setFeuilleSoins2(feuilleChaineFormat);
        break;
      case 3:
        setFeuilleSoins3(feuilleChaineFormat);
        break;
      case 4:
        setFeuilleSoins4(feuilleChaineFormat);
        break;
      case 5:
        setFeuilleSoins5(feuilleChaineFormat);
        break;
      case 6:
        setFeuilleSoins6(feuilleChaineFormat);
        break;
      case 7:
        setFeuilleSoins7(feuilleChaineFormat);
        break;
      case 8:
        setFeuilleSoins8(feuilleChaineFormat);
        break;
      case 9:
        setFeuilleSoins9(feuilleChaineFormat);
        break;
      case 10:
        setFeuilleSoins10(feuilleChaineFormat);
        break;
      case 11:
        setFeuilleSoins11(feuilleChaineFormat);
        break;
      case 12:
        setFeuilleSoins12(feuilleChaineFormat);
        break;
      case 13:
        setFeuilleSoins13(feuilleChaineFormat);
        break;
      case 14:
        setFeuilleSoins14(feuilleChaineFormat);
        break;
      case 15:
        setFeuilleSoins15(feuilleChaineFormat);
        break;
      case 16:
        setFeuilleSoins16(feuilleChaineFormat);
        break;
      case 17:
        setFeuilleSoins17(feuilleChaineFormat);
        break;
      case 18:
        setFeuilleSoins18(feuilleChaineFormat);
        break;
      case 19:
        setFeuilleSoins19(feuilleChaineFormat);
        break;
      case 20:
        setFeuilleSoins20(feuilleChaineFormat);
        break;
      default:
        break;
    }
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getFeuilleSoins1() {
    return feuilleSoins1;
  }

  public void setFeuilleSoins1(String feuilleSoins1) {
    this.feuilleSoins1 = feuilleSoins1;
  }

  public String getFeuilleSoins2() {
    return feuilleSoins2;
  }

  public void setFeuilleSoins2(String feuilleSoins2) {
    this.feuilleSoins2 = feuilleSoins2;
  }

  public String getFeuilleSoins3() {
    return feuilleSoins3;
  }

  public void setFeuilleSoins3(String feuilleSoins3) {
    this.feuilleSoins3 = feuilleSoins3;
  }

  public String getFeuilleSoins4() {
    return feuilleSoins4;
  }

  public void setFeuilleSoins4(String feuilleSoins4) {
    this.feuilleSoins4 = feuilleSoins4;
  }

  public String getFeuilleSoins5() {
    return feuilleSoins5;
  }

  public void setFeuilleSoins5(String feuilleSoins5) {
    this.feuilleSoins5 = feuilleSoins5;
  }

  public String getFeuilleSoins6() {
    return feuilleSoins6;
  }

  public void setFeuilleSoins6(String feuilleSoins6) {
    this.feuilleSoins6 = feuilleSoins6;
  }

  public String getFeuilleSoins7() {
    return feuilleSoins7;
  }

  public void setFeuilleSoins7(String feuilleSoins7) {
    this.feuilleSoins7 = feuilleSoins7;
  }

  public String getFeuilleSoins8() {
    return feuilleSoins8;
  }

  public void setFeuilleSoins8(String feuilleSoins8) {
    this.feuilleSoins8 = feuilleSoins8;
  }

  public String getFeuilleSoins9() {
    return feuilleSoins9;
  }

  public void setFeuilleSoins9(String feuilleSoins9) {
    this.feuilleSoins9 = feuilleSoins9;
  }

  public String getFeuilleSoins10() {
    return feuilleSoins10;
  }

  public void setFeuilleSoins10(String feuilleSoins10) {
    this.feuilleSoins10 = feuilleSoins10;
  }

  public String getFeuilleSoins11() {
    return feuilleSoins11;
  }

  public void setFeuilleSoins11(String feuilleSoins11) {
    this.feuilleSoins11 = feuilleSoins11;
  }

  public String getFeuilleSoins12() {
    return feuilleSoins12;
  }

  public void setFeuilleSoins12(String feuilleSoins12) {
    this.feuilleSoins12 = feuilleSoins12;
  }

  public String getFeuilleSoins13() {
    return feuilleSoins13;
  }

  public void setFeuilleSoins13(String feuilleSoins13) {
    this.feuilleSoins13 = feuilleSoins13;
  }

  public String getFeuilleSoins14() {
    return feuilleSoins14;
  }

  public void setFeuilleSoins14(String feuilleSoins14) {
    this.feuilleSoins14 = feuilleSoins14;
  }

  public String getFeuilleSoins15() {
    return feuilleSoins15;
  }

  public void setFeuilleSoins15(String feuilleSoins15) {
    this.feuilleSoins15 = feuilleSoins15;
  }

  public String getFeuilleSoins16() {
    return feuilleSoins16;
  }

  public void setFeuilleSoins16(String feuilleSoins16) {
    this.feuilleSoins16 = feuilleSoins16;
  }

  public String getFeuilleSoins17() {
    return feuilleSoins17;
  }

  public void setFeuilleSoins17(String feuilleSoins17) {
    this.feuilleSoins17 = feuilleSoins17;
  }

  public String getFeuilleSoins18() {
    return feuilleSoins18;
  }

  public void setFeuilleSoins18(String feuilleSoins18) {
    this.feuilleSoins18 = feuilleSoins18;
  }

  public String getFeuilleSoins19() {
    return feuilleSoins19;
  }

  public void setFeuilleSoins19(String feuilleSoins19) {
    this.feuilleSoins19 = feuilleSoins19;
  }

  public String getFeuilleSoins20() {
    return feuilleSoins20;
  }

  public void setFeuilleSoins20(String feuilleSoins20) {
    this.feuilleSoins20 = feuilleSoins20;
  }

  public String getTotalActesEtDeplacements() {
    return totalActesEtDeplacements;
  }

  public void setTotalActesEtDeplacements(String totalActesEtDeplacements) {
    this.totalActesEtDeplacements = totalActesEtDeplacements;
  }

  public String getMontantAbattement() {
    return montantAbattement;
  }

  public void setMontantAbattement(String montantAbattement) {
    this.montantAbattement = montantAbattement;
  }

  public String getMontantAPayer() {
    return montantAPayer;
  }

  public void setMontantAPayer(String montantAPayer) {
    this.montantAPayer = montantAPayer;
  }
}
