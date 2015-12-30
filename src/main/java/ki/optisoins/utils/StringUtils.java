package ki.optisoins.utils;

import java.util.Objects;
import java.util.StringJoiner;

public class StringUtils {

  public static boolean isEmpty(String ... s) {
    return s == null || "".equals(s);
  }

  public static boolean isNotEmpty(String s) {
    return !isEmpty(s);
  }

  public static boolean isOneNotEmpty(String ... strs) {
    for(String str : strs){
      if (isNotEmpty(str)){
        return true;
      }
    }
    return false;
  }

  public static String concat(String delimiter, String... elements) {
    Objects.requireNonNull(delimiter);
    Objects.requireNonNull(elements);

    StringJoiner joiner = new StringJoiner(delimiter);
    for (String e : elements) {
      if (StringUtils.isNotEmpty(e)) {
        joiner.add(e);
      }
    }
    return joiner.toString();
  }
}