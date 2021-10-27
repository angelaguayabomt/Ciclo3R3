/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.Ciclo3R3;

import com.usa.Ciclo3R3.Reservation;
import com.usa.Ciclo3R3.ReservationRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angys
 */
@Service
public class ServiciosReservation {
    @Autowired
    private ReservationRepositorio metodosCrud;
    
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    public Reservation getById(int idReservation) {
        Optional<Reservation> reservation = metodosCrud.getById(idReservation);
        return reservation.orElse(new Reservation());
    }
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null) {
            return metodosCrud.save(reservation);
        }else{
           Optional<Reservation> evt=metodosCrud.getById(reservation.getIdReservation());
            if (evt.isPresent()) {
            return metodosCrud.save(reservation);    
            }else{
                return reservation;
            }
        }
    }
}
