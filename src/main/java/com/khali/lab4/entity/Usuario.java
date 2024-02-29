package com.khali.lab4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_name")
    private String nome;

    @Column(name = "usr_password")
    private String senha;
    
}
