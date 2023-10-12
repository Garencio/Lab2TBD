package com.lab1tbd.services;

import com.lab1tbd.models.Voluntario;
import com.lab1tbd.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public Voluntario findVoluntarioByEmail(String email) {
        return voluntarioRepository.findVoluntarioByEmail(email);
    }

    public Long saveVoluntario(Voluntario voluntario) {
        return voluntarioRepository.createVoluntario(voluntario);
    }


}
