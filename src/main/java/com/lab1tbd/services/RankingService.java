package com.lab1tbd.services;

import com.lab1tbd.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;


    public int getCantidadVoluntariosPorTarea(Long tareaId) {
        return rankingRepository.countVoluntariosByTareaId(tareaId);
    }
}
