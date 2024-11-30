package br.com.jtigik.service.repositories;

import java.util.List;

import br.com.jtigik.domain.Conta;

public interface ContaRepository {

    Conta salvar(Conta conta);

    List<Conta> obterContasPorUsuario(Long usuarioId);

    void delete(Conta conta);
}
