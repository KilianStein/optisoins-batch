package ki.optisoins;

import ki.optisoins.mapper.xls.XlsExtract;
import ki.optisoins.properties.ConfigurationProperties;
import org.junit.Test;

import java.io.IOException;


public class XlsExtractTest {

    @Test
    public void extractTest() throws IOException {
        new XlsExtract().extract();
    }

}