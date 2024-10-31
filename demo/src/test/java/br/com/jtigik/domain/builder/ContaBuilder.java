package br.com.jtigik.domain.builder;

import br.com.jtigik.domain.Conta;
import br.com.jtigik.domain.Usuario;

public class ContaBuilder {

    private static void inicializarDadosPadroes(ContaBuilder builder) {
        builder.id = 1L;
        builder.nome = "Conta Válida";
        builder.usuario = UsuarioBuilder.umUsuario().agora();
    }

    private Long id;
    private String nome;
    private Usuario usuario;

    private ContaBuilder() {
    }

    public static ContaBuilder umaConta() {
        ContaBuilder builder = new ContaBuilder();
        inicializarDadosPadroes(builder);
        return builder;
    }

    public ContaBuilder comId(Long param) {
        this.id = param;
        return this;
    }

    public ContaBuilder comNome(String param) {
        this.nome = param;
        return this;
    }

    public ContaBuilder comUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Conta agora() {
        return new Conta(id, nome, usuario);
    }

}
