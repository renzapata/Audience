package com.example.mintic.Auditorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.Auditorio.model.Audience;
import com.example.mintic.Auditorio.repository.RepositoryAudience;

@Service
public class ServiceAudience {
    
    @Autowired
    private RepositoryAudience repositoryAudience;

    
    public List<Audience> getAll() {
        return repositoryAudience.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return repositoryAudience.getAudience(id);
    }

    public Audience save(Audience audience) {
        if (audience.getId() == null) {
            return repositoryAudience.save(audience);
        } else {
            Optional<Audience> audience1 = repositoryAudience.getAudience(audience.getId());
            if (audience1.isEmpty()) {
                return repositoryAudience.save(audience);
            } else {
                return audience;
            }
        }
    }
    public Audience update(Audience audience){
        if(audience.getId()!=null){
            Optional<Audience e= repositoryAudience.getAudience(audience.getId());
            if(!e.isEmpty()){
                if(audience.getName()!=null){
                    e.get().setName(audience.getName());
                }
                if(audience.getOwner()!=null){
                    e.get().setOwner(audience.getOwner());
                }
                if(audience.getCapacity()!=null){
                    e.get().setCapacity(audience.getCapacity());
                }
                if(audience.getDescription()!=null){
                    e.get().setDescription(audience.getDescription());
                }
                if(audience.getCategory()!=null){
                    e.get().setCategory(audience.getCategory());
                }
                repositoryAudience.save(e.get());
                return e.get();
            }else{
                return audience;
            }
        }else{
            return audience;
        }
    }
    
    
         public boolean deleteAudience(int id){
        Boolean d = getAudience(id).map(audience -> {
            repositoryAudience.delete(audience);
            return true;
        }).orElse(false);
        return d;  
    }

}
