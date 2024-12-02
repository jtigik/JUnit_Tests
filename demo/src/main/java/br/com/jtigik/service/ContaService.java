package br.com.jtigik.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.jtigik.domain.Conta;
import br.com.jtigik.domain.exceptions.ValidationException;
import br.com.jtigik.service.event.ContaEvent;
import br.com.jtigik.service.event.ContaEvent.EventType;
import br.com.jtigik.service.repositories.ContaRepository;

public class ContaService {

    private final ContaRepository repository;
    private final ContaEvent event;

    public ContaService(ContaRepository repository, ContaEvent event) {
        this.repository = repository;
        this.event = event;
    }

    public Conta salvar(Conta conta) {
        List<Conta> contas = repository.obterContasPorUsuario(conta.usuario().getId());
        contas.stream().forEach(contaExistente -> {
            if (conta.nome().equalsIgnoreCase(contaExistente.nome())) {
                throw new ValidationException("Usuário já possui uma conta com este nome");
            }
        });
        Conta contaPersistida = repository.salvar(new Conta(conta.id(), conta.nome() + LocalDateTime.now(), conta.usuario()));
        try {
            event.dispatch(contaPersistida, EventType.CREATED);
        } catch (Exception e) {
            repository.delete(contaPersistida);
            throw new RuntimeException("Falha na criação da Conta, tente novamente!");
        }

        return contaPersistida;
    }
}
