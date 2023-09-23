package com.application.vocealuga.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue
    @Column(name = "id_transacao")
    private Long idTransacao;
    private String forma;
    private String descricao;
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "id_funcionario")
    private Long idFuncionario;
}
