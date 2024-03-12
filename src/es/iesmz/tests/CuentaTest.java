package es.iesmz.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    @Test
    void testCompruebaIBAN() {
        Cuenta c = new Cuenta("ES6621000418401234567891", "Juan");
        assertTrue(c.compruebaIBAN("ES6621000418401234567891"));
    }


}