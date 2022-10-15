package com.example.mintic.Auditorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.Auditorio.repository.RepositoryScore;

@Service
public class ServiceScore {
    
    @Autowired
    private RepositoryScore repositoryScore;
}
