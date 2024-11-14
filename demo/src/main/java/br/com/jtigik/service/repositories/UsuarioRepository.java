package br.com.jtigik.service.repositories;

import java.util.Optional;

import br.com.jtigik.domain.Usuario;

public interface UsuarioRepository {

    Usuario salvar(Usuario usuario);

    Optional<Usuario> getUserByEmail(String email);
}
