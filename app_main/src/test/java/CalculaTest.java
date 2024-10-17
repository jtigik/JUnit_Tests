
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.example.Main;

public class CalculaTest {

    Main ct = new Main();

    @Test
    public void testaSoma() {
        assertEquals(13, ct.soma(5, 8));
    }
}
