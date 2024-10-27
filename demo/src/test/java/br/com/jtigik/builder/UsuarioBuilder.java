package br.com.jtigik.builder;

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
        builder.id = 2L;
        builder.nome = "Usuário válido";
        builder.email = "user@mail.com";
        builder.senha = "123456";
    }
}
