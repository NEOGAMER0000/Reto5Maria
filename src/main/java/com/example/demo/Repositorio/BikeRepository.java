/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Inteface.BikeInterface;
import com.example.demo.Modelo.Bike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */

@Repository

public class BikeRepository {
     @Autowired
    private BikeInterface extensionesCrud;
    
    public List<Bike> getAll(){
        return (List<Bike>) extensionesCrud.findAll();
    }
    
    public Optional<Bike> getBike(int id){
        return extensionesCrud.findById(id);
    }
    
    public Bike save (Bike bike){
        return extensionesCrud.save(bike);
    } 
    
    public void delete (Bike bike){
        extensionesCrud.delete(bike);
    }
}
