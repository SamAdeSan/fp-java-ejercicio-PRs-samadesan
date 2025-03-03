package org.example.calculadora;

import static org.example.calculadora.Potencia.potencia;

public class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }
    public static int multiplicar(inta, int b){
        return a * b;
    }

    // TODO: Agrega nuevas operaciones aquí (multiplicación, división, etc.)

    public static void main(String[] args) {
        System.out.println("Suma: " + sumar(5, 3));
        System.out.println("Resta: " + restar(5, 3));
        RedondeodeNumeros redondeodeNumeros=new RedondeodeNumeros(5.5);
        System.out.println(redondeodeNumeros.numerordondejat());
        System.out.println(potencia(5,3));
    }
}
