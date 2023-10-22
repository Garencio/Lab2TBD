package com.lab1tbd.services;

import com.lab1tbd.models.Emergencia;
import com.lab1tbd.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    public Long guardarEmergencia(Emergencia emergencia) {
        return emergenciaRepository.createEmergencia(emergencia);
    }
}
