package com.example.mintic.Auditorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.Auditorio.model.Audience;
import com.example.mintic.Auditorio.repository.crud.CrudRepositoryBike;

@Repository
public class RepositoryAudience {
    
    @Autowired
    private CrudRepositoryBike crudRepositoryAudience;


    public List<Audience> getAll(){
        return (List<Audience>) crudRepositoryAudience.findAll();
    }
    public Optional<Audience> getAudience(int id){
        return crudRepositoryAudience.findById(id);
    }
    
    public Audience save(Audience audience){
        return crudRepositoryAudience.save(audience);
    }

    public void delete(Audience audience){
        crudRepositoryAudience.delete(audience);
    }

}
