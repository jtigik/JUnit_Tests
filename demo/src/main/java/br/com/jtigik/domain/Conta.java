package br.com.jtigik.domain;

public class Conta {

    private Long id;
    private String nome;
    private Usuario usuario;

    public Conta(Long id, String nome, Usuario usuario) {
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
