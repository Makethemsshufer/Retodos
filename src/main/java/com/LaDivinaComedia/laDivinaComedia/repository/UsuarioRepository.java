/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.repository;

import com.LaDivinaComedia.laDivinaComedia.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.LaDivinaComedia.laDivinaComedia.repository.crud.UsuarioCrudRepository;

/**
 *
 * @author wmg_m
 */
@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public User guardar(User user){
        return userCrudRepository.save(user);
    }
    
    
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    public User actualizar(User usuario) {
        return userCrudRepository.save(usuario);
    }

    public boolean verificarEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return usuario.isPresent();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

   public void delete(User user) {
        userCrudRepository.delete(user);
    }
    public List<User> getUserByIdOrEmailOrName(Integer id, String email, String name) {
        return userCrudRepository.findByIdOrEmailOrName(id, email, name);
    }


}
