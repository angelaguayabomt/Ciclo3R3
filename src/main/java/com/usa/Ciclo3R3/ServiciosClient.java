/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.Ciclo3R3;

import com.usa.Ciclo3R3.Client;
import com.usa.Ciclo3R3.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angys
 */
@Service
public class ServiciosClient {
    @Autowired
    private ClientRepositorio metodosCrud;
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Client getById(int idClient) {
        Optional<Client> client = metodosCrud.getById(idClient);
        return client.orElse(new Client());
    }
    
    public Client save(Client client){
        if (client.getIdClient()==null) {
            return metodosCrud.save(client);
        }else{
           Optional<Client> evt=metodosCrud.getById(client.getIdClient());
            if (evt.isPresent()) {
            return metodosCrud.save(client);    
            }else{
                return client;
            }
        }
    }
    
}
