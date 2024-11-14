package br.com.jtigik.infra;

import java.util.Optional;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.domain.builder.UsuarioBuilder;
import static br.com.jtigik.domain.builder.UsuarioBuilder.umUsuario;
import br.com.jtigik.service.repositories.UsuarioRepository;

public class UsuarioDummyRepository implements UsuarioRepository {

    @Override
    public Usuario salvar(Usuario usuario) {
        return UsuarioBuilder.umUsuario()
                .comNome(usuario.getNome())
                .comEmail(usuario.getEmail())
                .comSenha(usuario.getSenha())
                .agora();
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        if ("user@mail.com".equals(email)) {
            return Optional.of(umUsuario().comEmail(email).agora());
        }
        return Optional.empty();
    }

}
