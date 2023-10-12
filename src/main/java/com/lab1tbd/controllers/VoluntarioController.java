package com.lab1tbd.controllers;

import com.lab1tbd.models.Voluntario;
import com.lab1tbd.services.JwtService;
import com.lab1tbd.services.VoluntarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/voluntario")
@Controller
public class VoluntarioController {

    private static final Logger logger = LoggerFactory.getLogger(VoluntarioController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    VoluntarioService voluntarioService;

    @PostMapping("/register")
    public ResponseEntity<Voluntario> registerVoluntario(@RequestBody Voluntario voluntario) {
        Voluntario Vol = voluntarioService.findVoluntarioByEmail(voluntario.getEmail());
        if (Vol != null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            voluntario.setContrasena(bCryptPasswordEncoder.encode(voluntario.getContrasena()));
            voluntario.setFechaRegistro(LocalDateTime.now());
            Long id = voluntarioService.saveVoluntario(voluntario);
            voluntario.setId(id);
            return ResponseEntity.ok(voluntario);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginVoluntario(@RequestBody Voluntario voluntario) {
        Voluntario Vol = voluntarioService.findVoluntarioByEmail(voluntario.getEmail());
        if (Vol == null || !bCryptPasswordEncoder.matches(voluntario.getContrasena(), Vol.getContrasena())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
        String token = jwtService.generateTokenForVoluntario(Vol);
        return ResponseEntity.ok(token);
    }

}
