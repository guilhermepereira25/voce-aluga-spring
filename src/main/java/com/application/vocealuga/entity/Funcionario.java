package com.application.vocealuga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario extends Cliente {
    private String cargo;
    protected String senha;
    @Id
    @GeneratedValue
    @Column(name = "id_funcionario")
    private Long id;
}
