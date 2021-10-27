/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.Ciclo3R3;

import com.usa.Ciclo3R3.interfaceComputer;
import com.usa.Ciclo3R3.Computer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angys
 */
@Repository
public class ComputerRepositorio {
    @Autowired
    private interfaceComputer crud;
    
    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();
    }
    
    public Computer save(Computer computer){
    return crud.save(computer);
    }
    
    public Optional<Computer> getById(int idComputer){
    return crud.findById(idComputer);               
    }

}
