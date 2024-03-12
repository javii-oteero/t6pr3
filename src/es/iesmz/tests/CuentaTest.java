package es.iesmz.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    @Test
    void testCompruebaIBAN() {
        Cuenta c = new Cuenta("ES6621000418401234567891", "Juan");
        assertTrue(c.compruebaIBAN("ES6621000418401234567891"));
        assertTrue(c.compruebaIBAN("ES6000491500051234567892"));
        assertTrue(c.compruebaIBAN("ES9420805801101234567891"));

        assertFalse(c.compruebaIBAN("ES7600246912501234567891"));
        assertFalse(c.compruebaIBAN("ES4721000418401234567891"));
        assertFalse(c.compruebaIBAN("ES8200491500051234567892"));
    }

    @Test
    void testGeneralIBAN() {
        Cuenta c = new Cuenta("", "");
        String iban = c.generalIBAN("0030","2053","09","1234567895");
        assertEquals("ES7100302053091234567895", iban);
        String iban2 = c.generalIBAN("0049","2352","08","2414205416");
        assertEquals("ES1000492352082414205416", iban2);
        String iban3 = c.generalIBAN("2085","2066","62","3456789011");
        assertEquals("ES1720852066623456789011", iban3);
    }

    @Test
    void testGeneralIbanNull() {
        Cuenta c = new Cuenta("", "");
        assertNull(c.generalIBAN("2085","2066","62","3456AE9011"));
        assertNull(c.generalIBAN("208","2066","62","3456789011"));
        assertNull(c.generalIBAN("2080","20A6","62","3456789011"));
        assertNull(c.generalIBAN("2080","2086","6","3456789011"));
        assertNull(c.generalIBAN("2080","2086","63","345678911"));
    }

}