package br.com.jtigik.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.jtigik.domain.exceptions.ValidationException;

@DisplayName("Domíno: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido() {
        Usuario usuario = new Usuario(1L, "Usuário válido", "user@mail.com", "123456");

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
                -> new Usuario(1L, null, "user@mail.com", "123456"));
        assertEquals("Nome é obrigatório!\n", ex.getMessage());
    }

}