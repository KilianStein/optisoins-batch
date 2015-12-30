package ki.optisoins.mapper.xls;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FeuilleSoinsXlsExtractTest {

  @Test
  public void testExtract() throws Exception {
    List<FeuilleSoinsXls> feuillesSoinsXls = new FeuilleSoinsXlsExtract().extract();
    for (FeuilleSoinsXls feuilleSoinsXls : feuillesSoinsXls){
      System.out.println(feuilleSoinsXls.toString());
      System.out.println("--------------");
    }

  }
}