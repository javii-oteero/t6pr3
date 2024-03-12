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
        Cuenta c = new Cuenta("ES6621000418401234567891", "Juan");
        String iban = c.generalIBAN("0030","2053","09","1234567895");
        assertEquals("ES7100302053091234567895", iban);
    }

}