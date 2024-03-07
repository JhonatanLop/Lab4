package com.khali.lab4.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.khali.lab4.entity.Anotacao;
import com.khali.lab4.repository.AnotacaoRepository;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Anotacao> findAll(){
        return anotacaoRepository.findAll();
    }
    
    public Anotacao newAnotacao(Anotacao anotacao){
        if (anotacao == null ||
            anotacao.getTexto() == null ||
            anotacao.getTexto().isBlank()||
            anotacao.getUsuario() == null ||
            anotacao.getUsuario().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "erro");
        }
        if (anotacao.getDataHora() == null) {
            anotacao.setDataHora(LocalDateTime.now());
        }
        anotacao.setUsuario(usuarioService.findUserById(anotacao.getUsuario().getId()));
        return anotacaoRepository.save(anotacao);
    }
    
}
