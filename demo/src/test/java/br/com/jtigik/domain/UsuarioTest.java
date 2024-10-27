package br.com.jtigik.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Domíno: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido() {
        Usuario usuario = new Usuario(1L, null, "user@mail.com", "123456");

        assertEquals(1L, usuario.getId());
        assertEquals("Usuário válido", usuario.getNome());
        assertEquals("user@mail.com", usuario.getEmail());
        assertEquals("123456", usuario.getSenha());
    }

}
