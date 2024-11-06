package br.com.jtigik.infra;

import java.util.Optional;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.service.repository.UsuarioRepository;

public class UsuarioMemoryRepository implements UsuarioRepository {

    @Override
    public Usuario salvar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
