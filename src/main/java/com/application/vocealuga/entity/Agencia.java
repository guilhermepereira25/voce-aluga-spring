package com.application.vocealuga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agencia")
public class Agencia {
    @Id
    @GeneratedValue
    private Long id_agencia;

    @Column(name = "contato")
    private String contato;

    @Column(name = "relatorio")
    private String relatorio;


}
