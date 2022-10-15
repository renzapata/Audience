package com.example.mintic.Auditorio.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.Auditorio.model.Reservation;
import com.example.mintic.Auditorio.repository.RepositoryReservation;

@Service
public class ServiceReservation {
    
    @Autowired
    private RepositoryReservation repositoryReservation;

    
    public List<Reservation> getAll() {
        return repositoryReservation.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return repositoryReservation.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return repositoryReservation.save(reservation);
        } else {
            Optional<Reservation> reservation1 = repositoryReservation.getReservation(reservation.getIdReservation());
            if (reservation1.isEmpty()) {
                return repositoryReservation.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= repositoryReservation.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                repositoryReservation.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
       public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation -> {
            repositoryReservation.delete(reservation);
            return true;
        }).orElse(false);
        return d;  
    }
       
       ////////////////////reto 5////////////////////////////////
       
     public Status getReservationStatusReport(){
         List<Reservation> completed = repositoryReservation.getReservationByStatus("completed");
         List<Reservation> cancelled = repositoryReservation.getReservationByStatus("cancelled");
         return new Status(completed.size(),cancelled.size());
     } 
     
     public List<Reservation> informePeriodoTiempoReservas(String datoA, String datoB){
         SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
         Date a = new Date();
         Date b = new Date();
         
         try{
             a = parser.parse(datoA);
             b = parser.parse(datoB);
         }catch(ParseException e){
             e.printStackTrace();
         }
         if(a.before(b)){
            return repositoryReservation.informePeriodoTiempoReservas(a, b);
         }else{
             return new ArrayList<>();
         }
     }
     
     public List<CountClient> getTopClients(){
         return repositoryReservation.getTopClient();
     }
     
}
