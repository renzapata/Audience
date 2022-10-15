package com.example.mintic.Auditorio.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.mintic.Auditorio.model.Reservation;
import com.example.mintic.Auditorio.service.ServiceReservation;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControllerReservation {

    @Autowired
    private ServiceReservation serviceReservation;

    
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return serviceReservation.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return serviceReservation.getReservation(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return serviceReservation.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return serviceReservation.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return serviceReservation.deleteReservation(reservationId);
    }
    
    ///////////////reto 5///////////////////////////////////
    
        @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return serviceReservation.getTopClients();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return serviceReservation.informePeriodoTiempoReservas(dateOne,dateTwo);
    }
    
     @GetMapping("/report-status")
    public Status getReservationsStatusReport(){
        return serviceReservation.getReservationStatusReport();
    }

}
