package ki.optisoins.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationsUtils {

  public static List<String> getFieldsNameWithAnnotation(Class classe, Class annotation) {
    List<String> fieldsNames = new ArrayList<>();
    for (Field field : ReflectUtils.getFields(classe)) {
      if (field.isAnnotationPresent(annotation)) {
        fieldsNames.add(field.getName());
      }
    }
    return fieldsNames;
  }

  public static List<String> getFieldsNameWithoutAnnotation(Class classe, Class annotation) {
    List<String> fieldsNames = new ArrayList<>();
    for (Field field : ReflectUtils.getFields(classe)) {
      if (!field.isAnnotationPresent(annotation)) {
        fieldsNames.add(field.getName());
      }
    }
    return fieldsNames;
  }
}
