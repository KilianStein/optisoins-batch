package ki.optisoins.utils;

import ki.optisoins.properties.ConfigurationProperties;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class UniqueNameUtils {
  private static final Set<String> namePool = new HashSet<>();

  public static String generateUniqueName(String dirName, String name) {
    String nameGenerated = name;
    for (int i = 1; namePool.contains(getNameUnique(dirName, nameGenerated)); i++) {
      nameGenerated = name + "_" + i;
    }
    namePool.add(getNameUnique(dirName, nameGenerated));
    return nameGenerated;
  }

  private static String getNameUnique(String dirName, String name){
    if (ConfigurationProperties.isUnDossierParExcel()){
      return dirName + File.separator + name;
    }
    return name;
  }
}
