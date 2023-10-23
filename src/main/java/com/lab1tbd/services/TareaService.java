package com.lab1tbd.services;

import com.lab1tbd.models.Tarea;

import com.lab1tbd.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getTareasByEmergenciaId(Long idEmergencia) {
        return tareaRepository.findTareasByEmergenciaId(idEmergencia);
    }

    public Long createTarea(Tarea tarea) {
        return tareaRepository.createTarea(tarea);
    }

    public void updateTarea(Tarea tarea) {
        tareaRepository.updateTarea(tarea);
    }

    public Tarea findTareaById(Long id) {
        return tareaRepository.findTareaById(id);
    }

    public void deleteTareaById(Long id) {
        tareaRepository.deleteTareaById(id);
    }
}