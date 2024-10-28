package br.com.jtigik.domain.builder;

import br.com.jtigik.domain.Usuario;

public class UsuarioBuilder {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    private UsuarioBuilder() {
    }

    public static UsuarioBuilder umUsuario() {
        UsuarioBuilder builder = new UsuarioBuilder();

        inicializarDadosPadrao(builder);

        return builder;
    }

    private static void inicializarDadosPadrao(UsuarioBuilder builder) {
        builder.id = 1L;
        builder.nome = "Usuário válido";
        builder.email = "user@mail.com";
        builder.senha = "123456";
    }

    public UsuarioBuilder comId(Long param) {
        id = param;
        return this;
    }

    public UsuarioBuilder comNome(String param) {
        nome = param;
        return this;
    }

    public UsuarioBuilder comEmail(String param) {
        email = param;
        return this;
    }

    public UsuarioBuilder comSenha(String param) {
        senha = param;
        return this;
    }

    public Usuario agora() {
        return new Usuario(id, nome, email, senha);
    }
}
