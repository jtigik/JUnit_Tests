
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.jtigik.testes.Calculadora;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        Calculadora calc = new Calculadora();
        Assertions.assertTrue(calc.soma(2, 3) == 5);

        Assertions.assertEquals(5, calc.soma(2, 3));
        Assertions.assertEquals(5, calc.soma(2, 3), "The sum should be 5");

    }
}
