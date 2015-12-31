package ki.optisoins.pojo;

import ki.optisoins.utils.StringUtils;

public class LienAssure {

  private Lien lien = null;
  private String value = "";

  public static LienAssure get(String lien) {
    if (StringUtils.isNotEmpty(lien)) {
      LienAssure lienAssure = new LienAssure();
      lienAssure.setLien(Lien.get(lien));
      lienAssure.setValue(Lien.getValue(lienAssure.getLien(), lien));
      return lienAssure;
    }
    return null;
  }

  public Lien getLien() {
    return lien;
  }

  public void setLien(Lien lien) {
    this.lien = lien;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String precision) {
    this.value = precision;
  }

  enum Lien {
    CONJOINT("conjoint"),
    CONCUBIN("concubin"),
    ENFANT("enfant"),
    AUTRE("autre"),
    TOUS("tous");

    private final String value;

    Lien(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public static Lien get(String lien) {
      if (StringUtils.isNotEmpty(lien)) {
        switch (lien.toLowerCase()) {
          case "conjoint":
          case "conjointe":
            return CONJOINT;
          case "concubin":
          case "concubine":
            return CONCUBIN;
          case "enfant":
            return ENFANT;
          case "tous":
          case "toute":
            return TOUS;
          default:
            return AUTRE;
        }
      }
      return null;
    }

    public static Lien getValue(String lien) {
      if (StringUtils.isNotEmpty(lien)) {

        switch (lien.toLowerCase()) {
          case "conjoint":
            return CONJOINT;
          case "concubin":
            return CONCUBIN;
          case "enfant":
            return ENFANT;
          case "tous":
            return TOUS;
          default:
            return AUTRE;
        }
      }
      return null;
    }

    public static String getValue(Lien lien, String lienValue) {
      if (lien != null) {
        if (AUTRE.equals(lien)) {
          return AUTRE.getValue() + ":" + lienValue;
        }
        return lien.getValue();
      }
      return "";
    }
  }
}
