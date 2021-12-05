/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.service;

import com.LaDivinaComedia.laDivinaComedia.model.HairProduct;
import com.LaDivinaComedia.laDivinaComedia.repository.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class HairProductServices {

    @Autowired
    private HairProductRepository hairProductRepository;

    public List<HairProduct> getAll() {
        return hairProductRepository.getAll();
    }

    public Optional<HairProduct> getProduct(String reference) {
        return hairProductRepository.getProduct(reference);
    }

    public HairProduct create(HairProduct hairProduct) {
        if (hairProduct.getReference() == null) {
            return hairProduct;
        } else {
            return hairProductRepository.create(hairProduct);
        }
    }

    
    
    public HairProduct update(HairProduct hairProduct) {
        Optional<HairProduct> existProduct = hairProductRepository.getProduct(hairProduct.getReference());
        if (existProduct.isPresent()) {
            if (hairProduct.getBrand() !=null) {
                existProduct.get().setBrand(hairProduct.getBrand());
            }
            if (hairProduct.getCategory() !=null) {
                existProduct.get().setCategory(hairProduct.getCategory());
            }
            if (hairProduct.getName() !=null) {
                existProduct.get().setName(hairProduct.getName());
            }
            if (hairProduct.getDescription() !=null) {
                existProduct.get().setDescription(hairProduct.getDescription());
            }
            if (hairProduct.getPrice() != 0.0) {
                existProduct.get().setPrice(hairProduct.getPrice());
            }
            if (hairProduct.getQuantity() != 0) {
                existProduct.get().setQuantity(hairProduct.getQuantity());
            }
            if (hairProduct.getPhotography()!=null) {
                existProduct.get().setPhotography(hairProduct.getPhotography());
            }
            return hairProductRepository.create(existProduct.get());
        } else {
            return hairProduct;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(product -> {
            hairProductRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
