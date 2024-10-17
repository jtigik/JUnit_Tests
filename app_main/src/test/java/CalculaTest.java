
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.example.Calculadora;

public class CalculaTest {

    Calculadora ct = new Calculadora();

    @Test
    public void somar() {
        assertEquals(13, ct.somar(5, 8));
    }

    //num = Numerador, den = Denominador
    public float dividir(int num, int den) {
        return num / den;
    }
}
