package org.example.calculadora;

public class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

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

    // TODO: Agrega nuevas operaciones aquí (multiplicación, división, etc.)

    public static void main(String[] args) {
        System.out.println("Suma: " + sumar(5, 3));
        System.out.println("Resta: " + restar(5, 3));
        System.out.println("Potencia: " + potencia(6, 3));
    }
}