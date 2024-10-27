package br.com.jtigik.domain;

import br.com.jtigik.domain.exceptions.ValidationException;

public class Usuario {

    private final Long id;
    private final String nome;
    private final String email;
    private final String senha;

    public Usuario(long id, String nome, String email, String senha) {

        if (nome == null) {
            throw new ValidationException("Nome é obrigatório!\n");
        }
        if (email == null) {
            throw new ValidationException("Nome é obrigatório!\n");
        }
        if (senha == null) {
            throw new ValidationException("Senha é obrigatória!\n");
        }

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
