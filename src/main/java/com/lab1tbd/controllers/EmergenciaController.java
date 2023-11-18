package com.lab1tbd.controllers;

import com.lab1tbd.models.Emergencia;
import com.lab1tbd.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emergencias")
public class EmergenciaController {

    @Autowired
    EmergenciaService emergenciaService;

    @GetMapping("/region/{nombreRegion}")
    public ResponseEntity<List<Emergencia>> getEmergenciasByRegion(@PathVariable String nombreRegion) {
        return ResponseEntity.ok(emergenciaService.getEmergenciasByRegion(nombreRegion));
    }
}
