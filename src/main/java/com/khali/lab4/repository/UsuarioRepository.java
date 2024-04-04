package com.khali.lab4.repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khali.lab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByNome(String nome);

    @Query("select u from Usuario u where u.nome = ?1")
    public Optional<Usuario> findUserByName(String nomeDoUsuario);
    
    /*
     *  Contains = texto está contido
     *  IgnoreCase = ignora maiúsculo e minúsculo
     */
    public Optional<Usuario> findUserByNameContainsIgnoreCase(String nomeDoUsuario);

    // usando like
    @Query("select u from Usuario u where nome like %?1%")
    public Optional<Usuario> findUserByNameExistente(String nomeDoUsuario);

    // buscar por dois parâmetros ao mesmo tempo
    public Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    // busca por um ou outro parâmetro
    public Optional<Usuario> findByNomeOrSenha(String nome, String senha);

    // usando join na tabela de autorização
    public Optional<Usuario> findByAutorizacoesNome(String nome);

    // usando jpql
    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public Optional<Usuario> buscaPorAutorizacao(String nome);
}