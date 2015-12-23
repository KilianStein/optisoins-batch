package ki.optisoins;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class XlsExtractTest {

    @Test
    public void extractTest() throws IOException {
        OptiSoinsProperties.initProperties();
        new XlsExtract().extract();
    }

}