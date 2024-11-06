package br.com.jtigik.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jtigik.domain.Usuario;
import br.com.jtigik.service.repository.UsuarioRepository;

public final class UsuarioMemoryRepository implements UsuarioRepository {

    private final List<Usuario> users;
    private Long currentId;

    public UsuarioMemoryRepository() {
        this.currentId = 0L;
        this.users = new ArrayList<>();
        salvar(new Usuario(currentId, "User #1", "user1@mail.com", "123456"));
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return new Usuario(nextId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        return users.stream().
                filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public void printUsers() {
        System.out.println(users);
    }

    private Long nextId() {
        return ++currentId;
    }

    public static void main(String[] args) {
        UsuarioMemoryRepository repo = new UsuarioMemoryRepository();
        repo.printUsers();
    }
}
