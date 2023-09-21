package com.application.vocealuga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "motorista")
public class Motorista extends Cliente {
    @Id
    @GeneratedValue
    private Long id_motorista;
    private String cnh;
    private String categoria;
    private String nome;

    private Long id_cliente;

    public Motorista() {
        super();
    }

    public Motorista(String nome, String cpf, String cnh, String categoria) {
        super();
        this.cnh = cnh;
        this.categoria = categoria;
    }

    public String getCnh() {
        return this.cnh;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
