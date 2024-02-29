package com.khali.lab4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.khali.lab4.entity.Usuario;
import com.khali.lab4.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario insertUsuario(Usuario usuario){
        if (usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()){
            
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados de usuário inválidos");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario findUserById(Long id){
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
        if (usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não econtrado");
        }
        return usuarioOp.get();
    }
}
