package com.khali.lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khali.lab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
