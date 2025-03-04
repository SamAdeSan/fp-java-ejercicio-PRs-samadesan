package org.example.calculadora;

public class Division {
    Division(int a, int b) {}

    /**
     * Cálculo de la división ({@code dividir}).
     * @param a Dividendo.
     * @param b Divisor.
     * @return Devolverá el resultado de la raíz.
     * @throws ArithmeticException Devolverá dos errores distintos de cálculo si hay error.
     */

    public static double dividir(int a, int b){

        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }

        return (double) a / b;
    }
}
