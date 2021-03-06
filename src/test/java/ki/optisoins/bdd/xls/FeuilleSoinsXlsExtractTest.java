package ki.optisoins.bdd.xls;

import ki.optisoins.OptiSoins;
import ki.optisoins.OptiSoinsConfiguration;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class FeuilleSoinsXlsExtractTest {

  @Test
  public void testExtract() throws Exception {
    List<FeuilleSoinsXls> feuillesSoinsXls = new FeuilleSoinsXlsExtract().extract(Paths.get(new File(OptiSoins.class.getClassLoader().getResource(OptiSoinsConfiguration.donneesDefault).getPath()).toURI()));
    for (FeuilleSoinsXls feuilleSoinsXls : feuillesSoinsXls){
      System.out.println(feuilleSoinsXls.toString());
      System.out.println("--------------");
    }
  }
}