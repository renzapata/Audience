package com.example.mintic.Auditorio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.Auditorio.repository.crud.CrudRepositoryScore;

@Repository
public class RepositoryScore {

    @Autowired
    private CrudRepositoryScore crudRepositoryScore;
}
