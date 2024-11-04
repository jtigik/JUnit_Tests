package br.com.jtigik.service;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.service.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario Salvar(Usuario usuario) {

        return repository.salvar(usuario);
    }

}
