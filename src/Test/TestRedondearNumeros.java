import org.example.calculadora.Calculadora;
import org.example.calculadora.RedondeodeNumeros;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRedondearNumeros {
    @Test
    public void testRedondearNumeros() {
        RedondeodeNumeros num1 = new RedondeodeNumeros(2.3);
        assertEquals(2, num1.numerordondejat(), "Debe redondear a 2");

        RedondeodeNumeros num2 = new RedondeodeNumeros(2.6);
        assertEquals(3, num2.numerordondejat(), "Debe redondear a 3");
    }
}
