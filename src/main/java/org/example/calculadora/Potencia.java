package org.example.calculadora;

public class Potencia {
    Potencia() {}
    /**
     * El siguiente metodo añade la funcionalidad de potencias a la calculadora
     * @param base Es el primer numero
     * @param exponente Este es el segundo el cual indicara las veces que la base se multiplique
     * @return el resultado de elevar la base al exponente
     */
    public static float potencia(int base, int exponente) {
        int c=base;
        for (int i = 1; i < exponente; i++) {
            base = exponente*c;
        }
        return base;
    }
}
