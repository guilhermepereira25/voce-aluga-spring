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
@Table(name = "permissao")
public class Permissao {
    @Id
    @GeneratedValue
    @Column(name = "id_permissao")
    private Long id;
    @Column(name = "cargo_permissao")
    private String cargo;
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "id_funcionario")
    private Long idFuncionario;
}
