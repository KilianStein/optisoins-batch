package ki.optisoins.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixelUtils {
  private static Logger logger = LoggerFactory.getLogger(PixelUtils.class);

  private static float CONVERT_MM_TO_PX = 2.8346f;

  public static int tranformToPixel(String marge) {
    if (StringUtils.isNotEmpty(marge)) {
      switch (getUnitMarge(marge)) {
        case "cm":
          return Math.round(getValeurMarge(marge, "cm") * CONVERT_MM_TO_PX * 10);
        case "mm":
          return Math.round(getValeurMarge(marge, "mm") * CONVERT_MM_TO_PX);
        case "px":
        default:
          return Math.round(getValeurMarge(marge, "px"));
      }
    }
    return 0;
  }

  public static float tranformPxToMM(int margePx) {
    return margePx / CONVERT_MM_TO_PX;
  }

  private static float getValeurMarge(String marge, String unitMarge) {
    return Float.parseFloat(marge.replace(unitMarge, "").replace(",", ".").trim());
  }

  private static String getUnitMarge(String marge) {
    if (marge.contains("px")) {
      return "px";
    } else if (marge.contains("mm")) {
      return "mm";
    } else if (marge.contains("cm")) {
      return "mm";
    }
    logger.warn("L'unité de la marge n'a pas été défini ou n'est pas supporté pour '{}'", marge);
    logger.warn("-> Les unités supportés sont 'px', 'mm', 'cm'");
    return "px";
  }
}
