
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.jtigik.testes.Calculadora;

public class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    private int contador = 0;

    @BeforeEach
    public void setup() {
        System.out.println("~~~~~~~~~~");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("^^^^^^^^");
    }

    @BeforeAll
    public static void setupAll() {
        System.out.println("--- BEFORE ALL ---");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("--- AFTER ALL ---");
    }

    @Test
    public void testandoUmTeste() {
        System.out.println(contador++);
        Assertions.assertTrue("casa".equalsIgnoreCase("CASA"));
    }

    @Test
    public void testSomar() {
        System.out.println(contador++);
        Assertions.assertTrue(calc.soma(2, 3) == 5);

        Assertions.assertEquals(5, calc.soma(2, 3));
        Assertions.assertEquals(5, calc.soma(2, 3), "The sum should be 5");

    }

    @Test
    public void assertivas() {
        System.out.println(contador++);
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

        Assertions.assertNull(s1, "Objeto não é NULO!");

        Assertions.assertNotNull(s1);

        // Assertions.fail("Falhou pelo seguinte motivo: AA");
    }

    @Test
    public void testSum() {
        System.out.println(contador++);

        int expected = 5;
        int actual = calc.soma(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void retornarNumeroInteiroNaDivisao() {
        System.out.println(contador++);

        float resultado = calc.divide(6, 2);

        Assertions.assertEquals(3, resultado);
    }

    @Test
    public void retornarNumeroNegativoNaDivisao() {
        System.out.println(contador++);

        float resultado = calc.divide(6, -2);

        Assertions.assertEquals(-3, resultado);
    }

    @Test
    public void retornarNumeroNegativoNaDivisao_II() {
        System.out.println(contador++);

        float resultado = calc.divide(16, -23);

    }

    @Test
    public void retornarNumeroDecimalNaDivisao() {
        System.out.println(contador++);

        float resultado = calc.divide(10, 3);

        Assertions.assertEquals(3.33, resultado, 0.01);
    }

    @Test
    public void retornarZeroComNumeradorZeroNaDivisao() {
        System.out.println(contador++);

        float resultado = calc.divide(0, 3);

        Assertions.assertEquals(0, resultado);
    }

    @Test
    public void deveLancarUmaExcecaoQuandoDividirPorZeroJUnit4() {
        System.out.println(contador++);

        try {
            float resultado = 10 / 0;

            Assertions.fail("Deveria ser lançada exceção na divisão");

        } catch (ArithmeticException e) {

            Assertions.assertEquals("/ by zero", e.getMessage());
        }

    }

    @Test
    public void deveLancarUmaExcecaoQuandoDividirPorZeroJUnit5() {
        System.out.println(contador++);

        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            float resultado = 10 / 0;
        });
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }
}
