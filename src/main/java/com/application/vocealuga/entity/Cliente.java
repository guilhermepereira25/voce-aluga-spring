package com.application.vocealuga.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue
    private Long id_cliente;
    protected String nome;

    @Column(name = "cpf", nullable = true)
    protected String cpf;

    @Column(name = "cnpj", nullable = true)
    protected String cnpj;

    @Column(name = "senha", nullable = false)
    protected String senha;

    protected Integer idade;

    protected String contato;

    public Cliente(String nome, String senha, Integer idade, String contato) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.contato = contato;
    }

    public Cliente(String nome, String senha, Integer idade, String contato, String cpf) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.contato = contato;
        this.cpf = cpf;
    }

    public Cliente(String nome, String senha, String cnpj, String contato, Integer idade) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.contato = contato;
        this.cnpj = cnpj;
    }

    public Cliente() {

    }

    public Long getId() {
        return id_cliente;
    }

    public void setId(Long id) {
        this.id_cliente = id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public String getContato() {
        return this.contato;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
