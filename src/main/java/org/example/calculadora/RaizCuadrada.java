package org.example.calculadora;

public class RaizCuadrada {

    /**
     <p>El método calculará la raíz cuadrada en la calculadora</p>

     <p>Modificaciones y cosas que he estado haciendo en el proyecto {@code Calculadora}: </p>
     <ul>
        <li>Modificar el proyecto para que se vea bien estructurado</li>
        <li>Hacer el proyecto aún más aseado</li>
        <li>Modificar el proyecto para que se vea estructurado</li>
     </ul>

     <p>Clases modificadas: {@link ValorAbsoluto}, {@link Division} y {@link Calculadora}.</p>
     <p>Mi clase creada: {@link RaizCuadrada}.</p>
     @Author: Samuel Aded Santafé
     */

    private final float numero;

    RaizCuadrada(float numero) {
        this.numero = numero;
    }

    /**
     * Cálculo de la raíz ({@code raizCuadrada}).
     *
     * @param numero Número a calcular
     * @return Devolverá el resultado de la raíz
     * @throws ArithmeticException Devolverá dos errores distintos de cálculo si hay error
     */
    public static float raizCuadrada(int numero) {
        float x = numero / 2.0f;
        float epsilon = 0.00001f;

        if (x == 0) {
            throw new ArithmeticException("No se puede hacer la raíz cuadrada de 0 por cero.");
        }

        else if (x < 0) {
            throw new ArithmeticException("No se puede hacer la raíz cuadrada de cualquier número negativo.");
        }

        else {
            do {
                x = (x + numero / x) / 2;
            }
            while ((Math.pow(x, 2) - numero) > epsilon);
        }

        return x;
    }
}
