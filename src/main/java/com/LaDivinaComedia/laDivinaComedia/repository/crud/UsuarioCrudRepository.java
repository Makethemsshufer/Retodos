/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.repository.crud;

import com.LaDivinaComedia.laDivinaComedia.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


/**
 *
 * @author wmg_m
 */
public interface UsuarioCrudRepository extends MongoRepository<User, Integer>{
    
   /**
    * Metodo que nos permite verificar que no existan 
    * @param id
    * @param email
    * @param name
    * @return 
    */
    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> findByEmail(String email);
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
 
   
}
