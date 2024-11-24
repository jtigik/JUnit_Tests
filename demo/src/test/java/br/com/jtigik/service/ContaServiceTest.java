package br.com.jtigik.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jtigik.domain.Conta;
import static br.com.jtigik.domain.builder.ContaBuilder.umaConta;
import br.com.jtigik.service.repositories.ContaRepository;

@SuppressWarnings("unused")
@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;
    @Mock
    private ContaRepository repository;

    @Test
    public void deveSalvarComSucesso() {
        Conta contaToSave = umaConta().comId(null).agora();

        Conta savedConta = service.salvar(contaToSave);

        Assertions.assertNotNull(savedConta.id());
    }

}
