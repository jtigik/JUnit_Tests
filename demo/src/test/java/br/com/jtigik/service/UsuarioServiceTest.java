package br.com.jtigik.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.jtigik.service.repository.UsuarioRepository;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Test
    @SuppressWarnings("static-access")
    public void deveRetornarUsuarioPorEmail() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        service.getUserByEmail("mail@mail.com");
        // Assertions.assertTrue(user.isEmpty());
    }

}
