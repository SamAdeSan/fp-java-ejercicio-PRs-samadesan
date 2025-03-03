package org.example.calculadora;

public class Raiz {

    public static double calcular(double numero, double indice) {
        return Math.pow(numero, 1.0 / indice);
    }

    public static double raizCuadrada(double numero) {
        return Math.sqrt(numero);
    }

    public static double raizCubica(double numero) {
        return Math.cbrt(numero);
    }
}