package br.com.jtigik.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.domain.builder.UsuarioBuilder;
import static br.com.jtigik.domain.builder.UsuarioBuilder.umUsuario;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.repositories.UsuarioRepository;

public class UsuarioServiceTest {

    @Mock
    private static UsuarioRepository repository;
    @InjectMocks
    private static UsuarioService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveRetornarEmptyQuandoUsuarioInexistente() {
        repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        Mockito.when(repository.getUserByEmail("mail@mail.com")).thenReturn(Optional.empty());

        Optional<Usuario> user = service.getUserByEmail("mail@mail.com");

        Assertions.assertFalse(user.isPresent());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void deveRetornarUsuarioPorEmail() {
        repository = mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        when(repository.getUserByEmail("mail@mail.com"))
                .thenReturn(Optional.of(umUsuario().agora()),
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

    @Test
    public void deveSalvarUsuarioComSucesso() {
        repository = mock(UsuarioRepository.class);
        service = new UsuarioService(repository);
        Usuario userToSave = umUsuario().comId(null).agora();

        when(repository.getUserByEmail(userToSave.getEmail())).
                thenReturn(Optional.empty());

        when(repository.salvar(userToSave)).thenReturn(umUsuario().agora());

        Usuario savedUser = service.salvar(userToSave);

        Assertions.assertNotNull(savedUser.getId());

        verify(repository).getUserByEmail(userToSave.getEmail());

        verify(repository).salvar(userToSave);
    }

    @Test
    public void deveRejeitarUsuarioExistente() {
        Usuario userToSave = umUsuario().comId(null).agora();

        when(repository.getUserByEmail(userToSave.getEmail()))
                .thenReturn(Optional.of(umUsuario().agora()));

        ValidationException e = Assertions.assertThrows(ValidationException.class, ()
                -> service.salvar(userToSave)
        );
        Assertions.assertTrue(e.getMessage().endsWith("já cadastrado!"));

        verify(repository, never()).salvar(userToSave);
    }
}
