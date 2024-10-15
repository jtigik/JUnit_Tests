
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void assertivas() {
        Assertions.assertEquals("casa", "casa");
        Assertions.assertNotEquals("casa", "Casa");

        Assertions.assertTrue("casa".equalsIgnoreCase("CASA"));
        Assertions.assertTrue("casa".endsWith("sa"));
        Assertions.assertTrue("casa".startsWith("ca"));

        List<String> s1 = new ArrayList<>();
        s1.add("Exemplo");
        List<String> s2 = new ArrayList<>();
        s2.add("Exemplo");
        List<String> s3 = null;

        Assertions.assertEquals(s1, s2);

        Assertions.assertSame(s1, s1);

        Assertions.assertNotEquals(s1, s3);

        Assertions.assertNull(s3);

        Assertions.assertNotNull(s1);

        // Assertions.fail("Falhou pelo seguinte motivo: AA");
    }
}
