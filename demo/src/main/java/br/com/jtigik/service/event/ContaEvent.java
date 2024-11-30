package br.com.jtigik.service.event;

import br.com.jtigik.domain.Conta;

public interface ContaEvent {

    public enum EventType {
        CREATED,
        UPDATED,
        DELETED
    }

    void dispatch(Conta conta, EventType type) throws Exception;

}
