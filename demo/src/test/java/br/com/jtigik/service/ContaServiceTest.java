package br.com.jtigik.service;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jtigik.domain.Conta;
import static br.com.jtigik.domain.builder.ContaBuilder.umaConta;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.event.ContaEvent;
import br.com.jtigik.service.event.ContaEvent.EventType;
import br.com.jtigik.service.repositories.ContaRepository;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;
    @Mock
    private ContaRepository repository;

    @Mock
    private ContaEvent event;

    @Captor
    private ArgumentCaptor<Conta> contaCaptor;

    @Test
    public void deveSalvarPrimeiraContaComSucesso() throws Exception {
        Conta contaToSave = umaConta().comId(null).agora();

        when(repository.salvar(Mockito.any(Conta.class))).thenReturn(umaConta().agora());

        Mockito.doNothing().when(event).dispatch(umaConta().agora(), EventType.CREATED);

        Conta savedConta = service.salvar(contaToSave);

        Assertions.assertNotNull(savedConta.id());

        Mockito.verify(repository).salvar(Mockito.any());
    }

    @Test
    public void deveSalvarContaMesmoJaExistindoOutras() {
        Conta contaToSave = umaConta().comId(null).agora();
        when(repository.obterContasPorUsuario(contaToSave.usuario().getId()))
                .thenReturn(Arrays.asList(umaConta().comNome("Outra conta").agora()));
        when(repository.salvar(Mockito.any(Conta.class))).thenReturn(umaConta().agora());

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

    @Test
    public void naoDeveManterContaSemEvento() throws Exception {
        Conta contaToSave = umaConta().comId(null).agora();
        Conta contaSalva = umaConta().agora();
        when(repository.salvar(Mockito.any(Conta.class))).thenReturn(contaSalva);

        Mockito.doThrow(new Exception("Falhou!!"))
                .when(event).dispatch(contaSalva, EventType.CREATED);

        String message = Assertions.assertThrows(Exception.class, ()
                -> service.salvar(contaToSave)).getMessage();

        Assertions.assertEquals("Falha na criação da Conta, tente novamente!", message);

        Mockito.verify(repository).delete(contaSalva);
    }

}
