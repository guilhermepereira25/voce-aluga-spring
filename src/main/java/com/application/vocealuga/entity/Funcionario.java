package com.application.vocealuga.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Cliente {
    private String cargo;

    protected String senha;

    @Id
    @GeneratedValue
    private Long id_funcionario;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String cpf, String cargo, String senha) {
        super();
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Long id) {
        this.id_funcionario = id;
    }

    public Long getId() {
        return id_funcionario;
    }
}
