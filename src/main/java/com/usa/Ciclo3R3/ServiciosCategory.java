/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.Ciclo3R3;

import com.usa.Ciclo3R3.Category;
import com.usa.Ciclo3R3.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angys
 */
@Service
public class ServiciosCategory {
    @Autowired
    private CategoryRepositorio metodosCrud;
    
    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    
    public Category getById(int idCategory) {
        Optional<Category> category = metodosCrud.getById(idCategory);
        return category.orElse(new Category());
    }
    
    public Category save(Category category){
        if (category.getIdCategory()==null) {
            return metodosCrud.save(category);
        }else{
           Optional<Category> evt=metodosCrud.getById(category.getIdCategory());
            if (evt.isPresent()) {
            return metodosCrud.save(category);    
            }else{
                return category;
            }
        }
    }
    
}
