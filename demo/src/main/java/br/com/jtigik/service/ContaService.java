package br.com.jtigik.service;

import java.util.List;

import br.com.jtigik.domain.Conta;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.repositories.ContaRepository;

public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta salvar(Conta conta) {
        List<Conta> contas = repository.obterContasPorUsuario(conta.usuario().getId());
        contas.stream().forEach(contaExistente -> {
            if (conta.nome().equalsIgnoreCase(contaExistente.nome())) {
                throw new ValidationException("Usuário já possui uma conta com este nome");
            }
        });
        return repository.salvar(conta);
    }
}
