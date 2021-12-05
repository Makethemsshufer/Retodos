/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.repository.crud;

import com.LaDivinaComedia.laDivinaComedia.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author wmg_m
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct, String>{
    

    
}
