package com.lab1tbd.controllers;

import com.lab1tbd.models.Coordinador;
import com.lab1tbd.models.Emergencia;
import com.lab1tbd.models.Tarea;
import com.lab1tbd.models.Voluntario;
import com.lab1tbd.services.CoordinadorService;
import com.lab1tbd.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/home")
    public String homePage(Model model, Principal principal) {

        String username = principal.getName();
        Coordinador coordinador = coordinadorService.findCoordinadorByEmail(username);

        coordinador.setContrasena(null);
        model.addAttribute("coordinador", coordinador);
        return "home";
    }
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
    public ResponseEntity<?> loginCoordinador(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("contrasena");

        Coordinador coordinador = coordinadorService.findCoordinadorByEmail(email);
        if (coordinador == null || !bCryptPasswordEncoder.matches(password, coordinador.getContrasena())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        String token = jwtService.generateTokenForCoordinador(coordinador);
        return ResponseEntity.ok(token);
    }





}
