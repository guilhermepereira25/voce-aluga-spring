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
@Table(name = "motorista")
public class Motorista extends Cliente {
    @Id
    @GeneratedValue
    @Column(name = "id_motorista")
    private Long id;
    private String cnh;
    private String categoria;
    private String nome;
    @Column(name = "id_cliente")
    private Long idCliente;

}
