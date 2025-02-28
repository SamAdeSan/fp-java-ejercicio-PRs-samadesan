package org.example.calculadora;

public class ValorAbsoluto {
    public static int valorAbsoluto(int valor) {
        return Math.abs(valor);
    }

    public static void main(String[] args) {
        System.out.println("Valor absoluto: " + valorAbsoluto(-10));
    }
}
