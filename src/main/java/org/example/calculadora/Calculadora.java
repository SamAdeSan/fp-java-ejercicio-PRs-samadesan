package org.example.calculadora;

import static org.example.calculadora.Division.dividir;
import static org.example.calculadora.Potencia.potencia;
import static org.example.calculadora.RaizCuadrada.raizCuadrada;
import static org.example.calculadora.ValorAbsoluto.valorAbsoluto;

public class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b){
        return a * b;
    }

    // TODO: Agrega nuevas operaciones aquí (multiplicación, división, etc.)

    public static void main(String[] args) {
        // Suma
        System.out.println("· Suma: " + sumar(5, 3));
        // Resta
        System.out.println("· Resta: " + restar(5, 3));
        // Multiplicación
        System.out.println("· Multiplica: " + multiplicar(5, 3));
        // División
        System.out.println("· Division: " + dividir(12, 3));
        // Potencia
        System.out.println("· Potencia: " + potencia(5,3));
        // Raíz Cuadrada
        System.out.println("· Raíz cuadrada: " + raizCuadrada(100));
        // Valor absoluto
        System.out.println("· Valor absoluto: " + valorAbsoluto(-10));
        // Redondear
        RedondeodeNumeros redondeodeNumeros = new RedondeodeNumeros(5.5);
        System.out.println("· Redondear: " + redondeodeNumeros.numerordondejat());

    }
}
