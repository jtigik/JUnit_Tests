package br.com.jtigik.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jtigik.domain.Transacao;
import static br.com.jtigik.domain.builder.TransacaoBuilder.umaTransacao;
import br.com.jtigik.service.repositories.TransacaoDao;

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

        Transacao transacaoSalva = service.salvar(transacaoParaSalvar);

        Assertions.assertNotNull(transacaoSalva.getId());
    }
}
