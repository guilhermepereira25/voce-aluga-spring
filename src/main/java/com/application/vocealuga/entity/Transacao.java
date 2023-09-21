package com.application.vocealuga.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue
    private Long id_transacao;

    public void setId_transacao(Long idTransacao) {
        this.id_transacao = idTransacao;
    }

    public Long getIdTransacao() {
        return id_transacao;
    }
}
