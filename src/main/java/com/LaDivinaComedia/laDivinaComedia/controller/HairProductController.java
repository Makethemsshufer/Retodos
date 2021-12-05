/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.controller;

import com.LaDivinaComedia.laDivinaComedia.model.HairProduct;
import com.LaDivinaComedia.laDivinaComedia.service.HairProductServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author wmg_m
 */
@RestController
@RequestMapping("/hairproducts")
@CrossOrigin("*")
public class HairProductController {
    @Autowired
    private HairProductServices hairProductServices;

    @GetMapping("/all")
    public List<HairProduct> getAll(){
        return hairProductServices.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<HairProduct> getProduct(@PathVariable("reference") String reference) {
        return hairProductServices.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct create(@RequestBody HairProduct hairProduct) {
        return hairProductServices.create(hairProduct);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct hairProduct) {
        return hairProductServices.update(hairProduct);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return hairProductServices.delete(reference);
    }
  
}
