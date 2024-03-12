package es.iesmz.tests;

import java.math.BigInteger;

public class Cuenta {
    private String numCuenta;
    private String titular;

    public Cuenta(String numCuenta, String titular) {
        this.numCuenta = numCuenta;
        this.titular = titular;
    }

    public boolean compruebaIBAN(String iban) {
        boolean esValido = true;
        if (iban.matches("ES\\d{22}")){
            String cs = iban.substring(4) + "142800";
            BigInteger num = new BigInteger(cs);
            BigInteger restoDivision = num.mod(new BigInteger("97"));
            BigInteger result = new BigInteger("98").subtract(restoDivision);
            int digitoControl = result.intValue();
            String digito;
            if (digitoControl > 10){
                digito = String.valueOf(digitoControl);
            } else {
                digito = "0" + digitoControl;
            }
            esValido = digito.equals(iban.substring(2, 4));
        } else {
            esValido = false;
        }
        return esValido;
    }

    public String generalIBAN(String entidad, String oficina, String dc, String cuenta) {
        return "";
    }
}
