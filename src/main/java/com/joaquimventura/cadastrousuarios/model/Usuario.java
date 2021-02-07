package com.joaquimventura.cadastrousuarios.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Lob
    @Column()
    private String avatar;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

}
