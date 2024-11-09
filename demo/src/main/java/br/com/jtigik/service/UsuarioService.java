package br.com.jtigik.service;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.repository.UsuarioRepository;

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        repository.getUserByEmail(usuario.getEmail()).ifPresent(user -> {
            throw new ValidationException(String.format("Usuário %s já cadastrado!", usuario.getEmail()));
        });
        return repository.salvar(usuario);
    }

}
