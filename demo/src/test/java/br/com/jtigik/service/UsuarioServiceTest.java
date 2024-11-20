package br.com.jtigik.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.domain.builder.UsuarioBuilder;
import br.com.jtigik.service.repositories.UsuarioRepository;

public class UsuarioServiceTest {

    private static UsuarioService service;

    @Test
    public void deveRetornarEmptyQuandoUsuarioInexistente() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        Mockito.when(repository.getUserByEmail("mail@mail.com")).thenReturn(Optional.empty());

        Optional<Usuario> user = service.getUserByEmail("mail@mail.com");

        Assertions.assertFalse(user.isPresent());
    }

    @Test
    public void deveRetornarUsuarioPorEmail() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        Mockito.when(repository.getUserByEmail("mail@mail.com"))
                .thenReturn(Optional.of(UsuarioBuilder.umUsuario().agora()));

        Optional<Usuario> user = service.getUserByEmail("mail@mail.com");

        Assertions.assertTrue(user.isPresent());

        System.out.println(user);

        Mockito.verify(repository).getUserByEmail("mail@mail.com");
    }
}
