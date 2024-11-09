package br.com.jtigik.infra;

import static br.com.jtigik.domain.builder.UsuarioBuilder.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.service.UsuarioService;

public class UserServiceComUserMemoryRepositoryTest {

    private UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());

    @Test
    public void devSalvarUsuarioValido() {
        Usuario user = service.salvar(umUsuario().comId(null).agora());

        Assertions.assertNotNull(user.getId());
    }
}
