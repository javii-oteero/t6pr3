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
            int digitoControl = calcularDigitoControl(cs);
            String digito;
            if (digitoControl >= 10){
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

    private int calcularDigitoControl(String cs) {
        BigInteger num = new BigInteger(cs);
        BigInteger restoDivision = num.mod(new BigInteger("97"));
        BigInteger result = new BigInteger("98").subtract(restoDivision);
        return result.intValue();
    }

    public String generalIBAN(String entidad, String oficina, String dc, String cuenta) {
        int digitoControl = calcularDigitoControl(String.format("%s%s%s%s%s", entidad, oficina, dc, cuenta, "142800"));
        String iban = String.format("ES%s%s%s%s%s", digitoControl, entidad, oficina, dc, cuenta);
        if (compruebaIBAN(iban)) {
            return iban;
        } else {
            return null;
        }
    }
}
