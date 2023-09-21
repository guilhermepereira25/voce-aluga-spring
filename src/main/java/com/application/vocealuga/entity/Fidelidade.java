package com.application.vocealuga.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "programa_fidelidade")
public class Fidelidade {
    @Id
    @GeneratedValue
    private Long id_fidelidade;
}
