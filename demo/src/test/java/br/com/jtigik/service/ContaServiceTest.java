package br.com.jtigik.service;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jtigik.domain.Conta;
import static br.com.jtigik.domain.builder.ContaBuilder.umaConta;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.repositories.ContaRepository;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;
    @Mock
    private ContaRepository repository;

    @Test
    public void deveSalvarPrimeiraContaComSucesso() {
        Conta contaToSave = umaConta().comId(null).agora();

        Conta savedConta = service.salvar(contaToSave);

        Assertions.assertNotNull(savedConta.id());
    }

    @Test
    public void deveSalvarContaMesmoJaExistindoOutras() {
        Conta contaToSave = umaConta().comId(null).agora();
        when(repository.obterContasPorUsuario(contaToSave.usuario().getId()))
                .thenReturn(Arrays.asList(umaConta().comNome("Outra conta").agora()));
        when(repository.salvar(contaToSave)).thenReturn(umaConta().agora());

        Conta savedConta = service.salvar(contaToSave);

        Assertions.assertNotNull(savedConta.id());
    }

    @Test
    public void deveRejeitarContaRepetida() {
        Conta contaToSave = umaConta().comId(null).agora();
        when(repository.obterContasPorUsuario(contaToSave.usuario().getId()))
                .thenReturn(Arrays.asList(umaConta().agora()));

        String message = Assertions.assertThrows(ValidationException.class, ()
                -> service.salvar(contaToSave)).getMessage();

        Assertions.assertEquals("Usuário já possui uma conta com este nome", message);
    }

}
