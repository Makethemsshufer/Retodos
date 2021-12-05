/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LaDivinaComedia.laDivinaComedia.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author wmg_m
 */

@Document(collection = "hairproducts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HairProduct {
    
@Id
private String reference;
private String brand;
private String category;
private String name;
private String description;
private boolean availability = true;
private double price;
private int quantity;
private String photography;
    
}
