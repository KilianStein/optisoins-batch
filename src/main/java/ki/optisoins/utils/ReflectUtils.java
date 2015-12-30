package ki.optisoins.utils;

import net.vidageek.mirror.dsl.Mirror;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectUtils {

  public static List<Field> getFields(Class classe) {
    return new Mirror().on(classe).reflectAll().fields();
  }

  public static List<Field> getFields(Object o) {
    return getFields(o.getClass());
  }

  public static Object getFieldValue(Object o, Field field) {
    return new Mirror().on(o).get().field(field.getName());
  }

  public static void setFieldValue(Object o, String fieldName, Object value){
    new Mirror().on(o).set().field(fieldName).withValue(value);
  }

  public static String toStringFields(Object o){
    String s = "";
    for (Field field : ReflectUtils.getFields(o)) {
      Object fieldValue = ReflectUtils.getFieldValue(o, field);
      if (ObjectUtils.isNotNullOrEmpty(fieldValue)) {
        s = StringUtils.concat("\n", s, field.getName() + "=" + fieldValue);
      }
    }
    return s;
  }
}
