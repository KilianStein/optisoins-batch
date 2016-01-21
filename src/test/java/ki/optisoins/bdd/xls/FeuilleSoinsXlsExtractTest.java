package ki.optisoins.bdd.xls;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import ki.optisoins.OptiSoins;

import org.junit.Test;

public class FeuilleSoinsXlsExtractTest {

  @Test
  public void testExtract() throws Exception {
    List<FeuilleSoinsXls> feuillesSoinsXls = new FeuilleSoinsXlsExtract().extract(Paths.get(new File(OptiSoins.class.getClassLoader().getResource("Test.xls").getPath()).toURI()));
    for (FeuilleSoinsXls feuilleSoinsXls : feuillesSoinsXls){
      System.out.println(feuilleSoinsXls.toString());
      System.out.println("--------------");
    }

  }
}