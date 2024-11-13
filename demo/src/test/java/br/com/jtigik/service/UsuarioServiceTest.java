package br.com.jtigik.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.jtigik.service.repository.UsuarioRepository;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Test
    public void deveSalvarUsuarioComSucesso() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(null);
    }

}
