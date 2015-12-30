package ki.optisoins.mapper.xls;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeuilleSoinsXlsTest {

    @Test
    public void testToString(){
        FeuilleSoinsXls feuilleSoinsXls = new FeuilleSoinsXls();
        assertEquals(getToStringStandard(feuilleSoinsXls), feuilleSoinsXls.toString());
    }

    @Test
    public void testToString1(){
        FeuilleSoinsXls feuilleSoinsXls = new FeuilleSoinsXls();
        feuilleSoinsXls.setTicketModerateur("monTicket");
        assertContain(feuilleSoinsXls, getToStringStandard(feuilleSoinsXls));
        assertContain(feuilleSoinsXls, "ticketModerateur=monTicket");
    }

    @Test
    public void testToString2(){
        FeuilleSoinsXls feuilleSoinsXls = new FeuilleSoinsXls();
        feuilleSoinsXls.setNomFichier("monFichier.xls");
        feuilleSoinsXls.setTicketModerateur("monTicket");
        assertContain(feuilleSoinsXls, getToStringStandard(feuilleSoinsXls));
        assertContain(feuilleSoinsXls, "ticketModerateur=monTicket");
        assertContain(feuilleSoinsXls, "nomFichier=monFichier.xls");
    }

    private static String getToStringStandard(Object object){
        return object.getClass().getName() + "@" + Integer.toHexString(object.hashCode());
    }

    private static void assertContain(Object object, String s){
        assertTrue("le message '" + object.toString() + "' ne contient pas la chaine '" + s + "'", object.toString().contains(s));
    }
}