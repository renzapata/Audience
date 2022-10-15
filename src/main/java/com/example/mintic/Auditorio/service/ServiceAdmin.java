package com.example.mintic.Auditorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.Auditorio.repository.RepositoryAdmin;

@Service
public class ServiceAdmin {
    
    @Autowired
    private RepositoryAdmin repositoryAdmin;
}
