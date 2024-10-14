
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.jtigik.testes.Calculadora;

public class CalculadoraTest {

    @Test
    public void testSomar() {
        Calculadora calc = new Calculadora();
        System.out.println(calc.soma(2, 7) == 5);
        Assertions.assertTrue(calc.soma(2, 7) == 5);

    }
}
