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
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue
    @Column(name = "id_veiculo")
    private Long id;
    private String placa;
    private String modelo;
    private String cor;
    private Integer ano;
    private Integer km;
    @Column(name = "situacao")
    private String status;
    @Column(name = "id_agencia")
    private Long idAgencia;
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "id_motorista")
    private Long idMotorista;
    @Column(name = "id_funcionario")
    private Long idFuncionario;
}
