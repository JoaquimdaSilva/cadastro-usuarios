package com.joaquimventura.cadastrousuarios.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
