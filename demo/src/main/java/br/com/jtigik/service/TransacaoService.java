package br.com.jtigik.service;

import java.time.LocalDateTime;

import br.com.jtigik.domain.Transacao;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.repositories.TransacaoDao;

public class TransacaoService {

    private TransacaoDao dao;

    public Transacao salvar(Transacao transacao) {

        if (LocalDateTime.now().getHour() > 24) {
            throw new RuntimeException("Tente novamente amanhã!");
        }

        if (transacao.getDescricao() == null) {
            throw new ValidationException("Descrição inexistente");
        }
        if (transacao.getValor() == null) {
            throw new ValidationException("Valor inexistente");
        }
        if (transacao.getData() == null) {
            throw new ValidationException("Data inexistente");
        }
        if (transacao.getConta() == null) {
            throw new ValidationException("Conta inexistente");
        }
        if (transacao.getStatus() == null) {
            transacao.setStatus(false);
        }
        return dao.salvar(transacao);
    }
}
