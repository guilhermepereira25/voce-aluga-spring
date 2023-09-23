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
@Table(name = "programa_fidelidade")
public class Fidelidade {
    @Id
    @GeneratedValue
    @Column(name = "id_programa_fidelidade")
    private Long id;
    @Column(name = "id_cliente")
    private Long idCliente;
}
