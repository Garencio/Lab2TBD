package com.lab1tbd.services;

import com.lab1tbd.models.Emergencia;
import com.lab1tbd.repositories.EmergenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaService {

    private EmergenciaRepository emergenciaRepository;

    @Autowired
    public EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }


    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.findAll();
    }

    public Long createEmergencia(Emergencia emergencia) {
        return emergenciaRepository.createEmergencia(emergencia);
    }

    public void updateEmergencia(Emergencia emergencia) {
        emergenciaRepository.updateEmergencia(emergencia);
    }

    public Emergencia findEmergenciaById(Long id) {
        return emergenciaRepository.findEmergenciaById(id);
    }

    public void deleteEmergenciaById(Long id) {
        emergenciaRepository.deleteEmergenciaById(id);
    }
}
