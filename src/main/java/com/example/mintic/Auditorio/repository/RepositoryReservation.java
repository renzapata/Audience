package com.example.mintic.Auditorio.repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.Auditorio.model.Reservation;
import com.example.mintic.Auditorio.repository.crud.CrudRepositoryReservation;


@Repository
public class RepositoryReservation {
    
    @Autowired
    private CrudRepositoryReservation crudRepositoryReservation;

    
    public List<Reservation> getAll(){
        return (List<Reservation>) crudRepositoryReservation.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crudRepositoryReservation.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crudRepositoryReservation.save(reservation);
    }

    public void delete(Reservation reservation){
        crudRepositoryReservation.delete(reservation);
    }
       
       ////////////////reto5////////////////////////////
       
       public List<Reservation> getReservationByStatus(String status){
           return crudRepositoryReservation.findAllByStatus(status);
       }
       
       public List<Reservation> informePeriodoTiempoReservas(Date a, Date b ){
           return crudRepositoryReservation.findAllByStartDateAfterAndStartDateBefore(a, b);
       }
       
       public List<CountClient> getTopClient(){
           List<CountClient> res = new ArrayList<>();
           List<Object[]> report = extencionesCrud.countTotalReservationByClient();
           for(int i=0;i<report.size();i++){
               res.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
           }
           return res;
       }
}
