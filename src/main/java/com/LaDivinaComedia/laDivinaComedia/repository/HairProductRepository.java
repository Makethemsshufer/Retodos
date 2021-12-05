/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.repository;

import com.LaDivinaComedia.laDivinaComedia.model.HairProduct;
import com.LaDivinaComedia.laDivinaComedia.repository.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wmg_m
 */
@Repository
public class HairProductRepository {

    @Autowired
    private HairProductCrudRepository hairProductCrudRepository;

    public List<HairProduct> getAll() {
        return hairProductCrudRepository.findAll();
    }

    public HairProduct create(HairProduct hairProduct) {
        return hairProductCrudRepository.save(hairProduct);
    }

    public void update(HairProduct hairProducts) {
        hairProductCrudRepository.save(hairProducts);
    }

    public void delete(HairProduct hairProducts) {
        hairProductCrudRepository.delete(hairProducts);
    }

    public Optional<HairProduct> getProduct(String reference) {
        return hairProductCrudRepository.findById(reference);
    }
}
