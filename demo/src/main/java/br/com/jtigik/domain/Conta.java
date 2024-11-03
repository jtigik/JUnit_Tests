package br.com.jtigik.domain;

import br.com.jtigik.domain.exceptions.ValidationException;

public class Conta {

    private Long id;
    private String nome;
    private Usuario usuario;

    public Conta(Long id, String nome, Usuario usuario) {
        if (nome == null) {
            throw new ValidationException("Nome é obrigatório!");
        }
        if (usuario == null) {
            throw new ValidationException("Usuário é obrigatório!");
        }

        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
    }

    long id() {
        return id;
    }

    Object nome() {
        return nome;
    }

    Object usuario() {
        return usuario;
    }

}
