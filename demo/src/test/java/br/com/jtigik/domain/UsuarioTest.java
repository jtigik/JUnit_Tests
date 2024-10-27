package br.com.jtigik.domain;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void deveCriarUsuarioValido() {
        Usuario usuario = new Usuario(1L, "Usuário válido", "user@mail.com", "123456");
    }

}
