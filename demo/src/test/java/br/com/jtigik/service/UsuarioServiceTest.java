package br.com.jtigik.service;

import org.junit.jupiter.api.Test;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Test
    public void deveSalvarUsuarioComSucesso() {
        service = new UsuarioService(null);
    }

}
