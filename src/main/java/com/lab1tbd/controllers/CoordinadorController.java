package com.lab1tbd.controllers;

import com.lab1tbd.models.Coordinador;
import com.lab1tbd.services.CoordinadorService;
import com.lab1tbd.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coordinador")
public class CoordinadorController {

    private static final Logger logger = LoggerFactory.getLogger(CoordinadorController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CoordinadorService coordinadorService;

    @PostMapping("/register")
    public ResponseEntity<Coordinador> registerCoordinador(@RequestBody Coordinador coordinador) {
        Coordinador coor = coordinadorService.findCoordinadorByEmail(coordinador.getEmail());
        if (coor != null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            coordinador.setContrasena(bCryptPasswordEncoder.encode(coordinador.getContrasena()));
            Long id = coordinadorService.saveCoordinador(coordinador);
            coordinador.setId(id);
            return ResponseEntity.ok(coordinador);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCoordinador(@RequestBody Coordinador coordinador) {
        Coordinador coor = coordinadorService.findCoordinadorByEmail(coordinador.getEmail());
        if (coor == null || !bCryptPasswordEncoder.matches(coordinador.getContrasena(), coor.getContrasena())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
        String token = jwtService.generateTokenForCoordinador(coor);
        return ResponseEntity.ok(token);
    }

}
