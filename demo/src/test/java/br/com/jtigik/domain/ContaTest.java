package br.com.jtigik.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.jtigik.domain.builder.ContaBuilder;
import static br.com.jtigik.domain.builder.ContaBuilder.umaConta;
import static br.com.jtigik.domain.builder.UsuarioBuilder.umUsuario;
import br.com.jtigik.domain.exceptions.ValidationException;

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

    @ParameterizedTest
    @MethodSource(value = "dataProvider")
    public void deveRejeitarContaInvalida(Long id, String nome, Usuario usuario, String mensagem) {
        String errorMessage = Assertions.assertThrows(ValidationException.class, ()
                -> umaConta().comId(id).comNome(nome).comUsuario(usuario).agora()).getMessage();
        Assertions.assertEquals(mensagem, errorMessage);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(1L, null, umUsuario().agora(), "Nome é obrigatório!"),
                Arguments.of(1L, "Conta Válida", null, "Usuário é obrigatório!")
        );
    }
}
