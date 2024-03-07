package com.khali.lab4.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ant_anotacao")
public class Anotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private long id;
    
    @Column(name = "ant_texto")
    private String texto;
    
    @Column(name = "ant_data_hora")
    private LocalDateTime dataHora;
    
    @ManyToOne
    @JoinColumn(name = "ant_usr_id")
    private Usuario usuario;

    public long getId() { return id; }
    public String getTexto() { return texto; }
    public LocalDateTime getDataHora() { return dataHora; }
    public Usuario getUsuario() { return usuario; }
    public void setId(long id) { this.id = id; }
    public void setTexto(String texto) { this.texto = texto; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }}
