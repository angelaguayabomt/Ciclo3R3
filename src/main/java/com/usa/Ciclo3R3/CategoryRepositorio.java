/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.Ciclo3R3;

import com.usa.Ciclo3R3.Category;
import com.usa.Ciclo3R3.interfaceCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angys
 */
@Repository
public class CategoryRepositorio {
    @Autowired
    private interfaceCategory crud;
    
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    
    public Category save(Category category){
    return crud.save(category);
    }
    
    public Optional<Category> getById(int idCategory){
    return crud.findById(idCategory);               
    }
}
