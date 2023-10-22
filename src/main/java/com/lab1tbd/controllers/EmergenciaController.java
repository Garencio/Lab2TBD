package com.lab1tbd.controllers;

import com.lab1tbd.models.Emergencia;
import com.lab1tbd.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emergencia")
@Controller
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping("/guardar")
    public ResponseEntity<Emergencia> guardarEmergencia(@RequestBody Emergencia emergencia) {
        Long id = emergenciaService.guardarEmergencia(emergencia);
        emergencia.setId(id);
        return ResponseEntity.ok(emergencia);
    }
}
