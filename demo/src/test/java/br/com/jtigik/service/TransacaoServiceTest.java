package br.com.jtigik.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jtigik.domain.Conta;
import br.com.jtigik.domain.Transacao;
import static br.com.jtigik.domain.builder.ContaBuilder.umaConta;
import static br.com.jtigik.domain.builder.TransacaoBuilder.umaTransacao;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.repositories.TransacaoDao;

/* @EnabledIf(value = "isHoraValida") */
@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService service;
    @Mock
    private TransacaoDao dao;

    @Test
    public void deveSalvarTransacaoValida() {

        Transacao transacaoParaSalvar = umaTransacao().comId(null).agora();
        Mockito.when(dao.salvar(transacaoParaSalvar)).thenReturn(umaTransacao().agora());

        LocalDateTime dataDesejada = LocalDateTime.of(2023, 1, 1, 4, 0);
        System.out.println(LocalDateTime.now());

        try (MockedStatic<LocalDateTime> ldt = Mockito.mockStatic(LocalDateTime.class)) {
            ldt.when(() -> LocalDateTime.now()).thenReturn(dataDesejada);
            System.out.println(LocalDateTime.now());
        }

        System.out.println(LocalDateTime.now());

        Transacao transacaoSalva = service.salvar(transacaoParaSalvar);
        Assertions.assertEquals(umaTransacao().agora(), transacaoSalva);
        Assertions.assertAll("transação",
                () -> assertEquals(1L, transacaoSalva.getId()),
                () -> assertEquals("Transação Válida", transacaoSalva.getDescricao()),
                () -> {
                    assertAll("Conta",
                            () -> assertEquals("Conta Válida", transacaoSalva.getConta().nome()),
                            () -> {
                                assertAll("Usuário",
                                        () -> assertEquals("Usuário válido", transacaoSalva.getConta().usuario().getNome()),
                                        () -> assertEquals("123456", transacaoSalva.getConta().usuario().getSenha())
                                );
                            }
                    );
                }
        );
    }

    @ParameterizedTest(name = "{6}")
    @MethodSource(value = "cenariosObrigatorios")
    public void deveValidarCamposObrigatoriosAoSalvar(
            Long id, String descricao, Double valor, LocalDate data, Conta conta, Boolean status, String mensagem
    ) {
        String exMessage = Assertions.assertThrows(ValidationException.class, () -> {
            Transacao transacao
                    = umaTransacao().comId(id).comDescricao(descricao).comValor(valor).comData(data).comStatus(status).comConta(conta).agora();
            service.salvar(transacao);
        }).getMessage();

        Assertions.assertEquals(mensagem, exMessage);
    }

    @SuppressWarnings("unused")
    static Stream<Arguments> cenariosObrigatorios() {
        return Stream.of(
                Arguments.of(1L, null, 10D, LocalDate.now(), umaConta().agora(), true, "Descrição inexistente"),
                Arguments.of(1L, "Descrição", null, LocalDate.now(), umaConta().agora(), true, "Valor inexistente"),
                Arguments.of(1L, "Descrição", 10D, null, umaConta().agora(), true, "Data inexistente"),
                Arguments.of(1L, "Descrição", 10D, LocalDate.now(), null, true, "Conta inexistente")
        );
    }

    /* public static boolean isHoraValida() {
        return LocalDateTime.now().getHour() < 20;
    } */
}
