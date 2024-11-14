package br.com.jtigik.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.service.repositories.UsuarioRepository;

public class UsuarioServiceTest {

    private static UsuarioService service;

    @Test
    public void deveRetornarUsuarioPorEmail() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        Optional<Usuario> user = service.getUserByEmail("mail@mail.com");

        Assertions.assertTrue(!user.isPresent());

        // Assertions.assertTrue(user.isEmpty());
    }
}
