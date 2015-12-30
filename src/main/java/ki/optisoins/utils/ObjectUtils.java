package ki.optisoins.utils;

public class ObjectUtils {

  public static boolean isNullOrEmpty(Object o) {
    return o == null || (o instanceof String && StringUtils.isEmpty((String) o));
  }

  public static boolean isNotNullOrEmpty(Object o) {
    return !isNullOrEmpty(o);
  }
}
