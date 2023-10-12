package com.lab1tbd.services;

import com.lab1tbd.models.Coordinador;
import com.lab1tbd.repositories.CoordinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinadorService {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    public Coordinador findCoordinadorByEmail(String email) {
        return coordinadorRepository.findCoordinadorByEmail(email);
    }

    public Long saveCoordinador(Coordinador coordinador) {
        return coordinadorRepository.createCoordinador(coordinador);
    }
}
