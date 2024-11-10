package br.com.jtigik.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.domain.builder.UsuarioBuilder;
import br.com.jtigik.infra.UsuarioDummyRepository;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Test
    public void deveSalvarUsuarioComSucesso() {
        service = new UsuarioService(new UsuarioDummyRepository());
        Usuario user = UsuarioBuilder.umUsuario().comId(null).agora();
        Usuario saveUser = service.salvar(user);
        Assertions.assertNotNull(saveUser.getId());
    }

}
