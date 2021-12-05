/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.service;

import com.LaDivinaComedia.laDivinaComedia.model.User;
import com.LaDivinaComedia.laDivinaComedia.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;
    
    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
   public Optional<User> getUser(int id) {
        
        return userRepository.getUser(id);
    }

    
    public boolean verificarEmail(String email){
        return userRepository.verificarEmail(email);
    }

 
    public User guardar(User user){
        if(user.getId() == null){
            return user;
        }else {
            if(user.getIdentification() == null || user.getName() == null || user.getAddress() == null || user.getCellPhone() == null || user.getEmail() == null 
                    || user.getPassword() == null || user.getZone() == null || user.getType() == null){
                return userRepository.guardar(user);
            }else{
                List<User> existeUsuario = userRepository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                if (existeUsuario.isEmpty()){
                    return userRepository.guardar(user);
                }else{
                    return user;
                }
            }
        }
    }

    
    
    public User update(User usuario) {
        Optional<User> existUser = userRepository.getUser(usuario.getId());
        if (existUser.isPresent()) {
            if (usuario.getIdentification() !=null) {
                existUser.get().setIdentification(usuario.getIdentification());
            }
            if (usuario.getName() !=null) {
                existUser.get().setName(usuario.getName());
            }
            if (usuario.getAddress() !=null) {
                existUser.get().setAddress(usuario.getAddress());
            }
            if (usuario.getCellPhone() !=null) {
                existUser.get().setCellPhone(usuario.getCellPhone());
            }
            if (usuario.getEmail() !=null) {
                existUser.get().setEmail(usuario.getEmail());
            }
            if (usuario.getPassword() !=null) {
                existUser.get().setPassword(usuario.getPassword());
            }
            if (usuario.getZone() !=null) {
                existUser.get().setZone(usuario.getZone());
            }
            if (usuario.getType() !=null) {
                existUser.get().setType(usuario.getType());
            }
            return userRepository.guardar(existUser.get());
        } else {
            return usuario;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (!usuario.isPresent()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

}
