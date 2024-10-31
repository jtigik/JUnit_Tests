package br.com.jtigik.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.jtigik.domain.builder.ContaBuilder;
import static br.com.jtigik.domain.builder.UsuarioBuilder.umUsuario;

public class ContaTest {

    @Test
    public void deveCriarContaValida() {

        Conta conta = ContaBuilder.umaConta().agora();

        Assertions.assertAll("Conta",
                () -> Assertions.assertEquals(1L, conta.id()),
                () -> Assertions.assertEquals("Conta Válida", conta.nome()),
                () -> Assertions.assertEquals(umUsuario().agora(), conta.usuario())
        );

    }
}
