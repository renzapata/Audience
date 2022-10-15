package com.example.mintic.Auditorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.mintic.Auditorio.service.ServiceAdmin;

@RestController
public class ControllerAdmin {
    
    @Autowired
    private ServiceAdmin serviceAdmin;
}
