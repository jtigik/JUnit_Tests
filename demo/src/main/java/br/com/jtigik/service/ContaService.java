package br.com.jtigik.service;

import br.com.jtigik.domain.Conta;
import br.com.jtigik.service.repositories.ContaRepository;

public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta salvar(Conta conta) {
        return repository.salvar(conta);
    }
}
