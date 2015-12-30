package ki.optisoins.mapper.xls;

import java.util.List;

import org.junit.Test;

public class FeuilleSoinsXlsExtractTest {

  @Test
  public void testExtract() throws Exception {
    List<FeuilleSoinsXls> feuillesSoinsXls = new FeuilleSoinsXlsExtract().extract();
    for (FeuilleSoinsXls feuilleSoinsXls : feuillesSoinsXls){
      System.out.println(feuilleSoinsXls.toString());
      System.out.println("--------------");
      new FeuilleSoinsXlsMapper().map(feuilleSoinsXls);
    }

  }
}