package com.khali.lab4.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khali.lab4.entity.Usuario;
import com.khali.lab4.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/usuario")
// diz quem pode acessar
@CrossOrigin
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> findAll(){
        return service.findAllUsers();
    }

    @PostMapping
    public Usuario insertUsuario(@RequestBody Usuario usuario){
        return service.insertUsuario(usuario);
    }

    @GetMapping(value = "/{id}")
    public Usuario findByUserId(@PathVariable("id") Long id){
        return service.findUserById(id);
    }

}
