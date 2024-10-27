package br.com.jtigik.domain;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.jtigik.builder.UsuarioBuilder.umUsuario;
import br.com.jtigik.domain.exceptions.ValidationException;

@DisplayName("Domíno: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido() {
        Usuario usuario = umUsuario().agora();

        Assertions.assertAll("Usuário",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Usuário válido", usuario.getNome()),
                () -> assertEquals("user@mail.com", usuario.getEmail()),
                () -> assertEquals("123456", usuario.getSenha())
        );

    }

    @Test
    public void deveRejeitarUsuarioSemNome() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, ()
                -> umUsuario().comNome(null).agora());
        assertEquals("Nome é obrigatório!\n", ex.getMessage());
    }

}
