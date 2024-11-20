package br.com.jtigik.service;

import static org.mockito.Mockito.*;

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

    @SuppressWarnings("unchecked")
    @Test
    public void deveRetornarUsuarioPorEmail() {
        UsuarioRepository repository = mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        when(repository.getUserByEmail("mail@mail.com"))
                .thenReturn(Optional.of(UsuarioBuilder.umUsuario().agora()),
                        Optional.of(UsuarioBuilder.umUsuario().agora()),
                        null);

        Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
        System.out.println(user);
        // user = service.getUserByEmail("mailmail2@mail.com");
        System.out.println(user);
        user = service.getUserByEmail("mail@mail.com");
        System.out.println(user);

        Assertions.assertTrue(user.isPresent());

        verify(repository, Mockito.atLeastOnce()).getUserByEmail("mail@mail.com");
        verify(repository, Mockito.never()).getUserByEmail("outro.mail@mail.com");
        Mockito.verifyNoMoreInteractions(repository);
    }
}
