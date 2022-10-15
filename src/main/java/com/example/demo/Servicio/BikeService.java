/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Bike;
import com.example.demo.Repositorio.BikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service

public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;
    
    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }
    
    public Optional<Bike> getBike(int id){
        return bikeRepository.getBike(id);
    }
    
     public Bike save(Bike bike){
        if ( bike.getId()== null){
            return bikeRepository.save(bike);
        }else{
            Optional<Bike> bike1 = bikeRepository.getBike(bike.getId());
            if(bike1.isEmpty()){
                return bikeRepository.save(bike);
            }else{
                return bike;
            }
        }
    }
     
       public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> e= bikeRepository.getBike(bike.getId());
            if(!e.isEmpty()){
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.get().setCategory(bike.getCategory());
                }
                bikeRepository.save(e.get());
                return e.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }
     
        public boolean deleteBike(int id){
        Boolean d = getBike(id).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return d;
    }
}
