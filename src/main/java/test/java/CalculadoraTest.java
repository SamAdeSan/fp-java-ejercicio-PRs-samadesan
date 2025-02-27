package test.java;

import org.example.calculadora.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    @Test
    void testSuma() {
        Calculadora calc = new Calculadora();
        int resultado = calc.sumar(2, 3);
        assertEquals(5, resultado, "La suma de 2 y 3 debería ser 5");
    }

    @Test
    void testresta() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(10, 5);
        assertEquals(5, resultado, "La suma de 2 y 3 debería ser 5");
    }
}
