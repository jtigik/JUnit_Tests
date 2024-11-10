package br.com.jtigik.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.jtigik.domain.Usuario;
import static br.com.jtigik.domain.builder.UsuarioBuilder.umUsuario;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.UsuarioService;

@TestMethodOrder(MethodOrderer.class)
public class UserServiceComUserMemoryRepositoryTest {

    private static final UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());

    @Test
    @Order(1)
    public void devSalvarUsuarioValido() {

        Usuario user = service.salvar(umUsuario().comId(null).agora());

        Assertions.assertNotNull(user.getId());

        Assertions.assertEquals(2L, user.getId());
    }

    @Test
    @Order(2)
    public void deveRejeitarUsuarioExistente() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, ()
                -> service.salvar(umUsuario().comId(null).agora())
        );

        Assertions.assertEquals("Usuário user@mail.com já cadastrado!", ex.getMessage());
    }

}
