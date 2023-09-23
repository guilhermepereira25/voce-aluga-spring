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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue
    @Column(name = "id_cliente")
    private Long id;
    protected String nome;

    @Column(name = "cpf", nullable = true)
    protected String cpf;

    @Column(name = "cnpj", nullable = true)
    protected String cnpj;

    @Column(name = "senha", nullable = false)
    protected String senha;

    protected Integer idade;

    protected String contato;
}
