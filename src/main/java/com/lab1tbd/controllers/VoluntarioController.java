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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @GetMapping("/home")
    public String homePage(Model model, Principal principal) {
        // Obtiene el nombre de usuario del voluntario autenticado
        String username = principal.getName();
        Voluntario voluntario = voluntarioService.findVoluntarioByEmail(username);
        // Elimina la contraseña antes de enviar los datos a la vista
        voluntario.setContrasena(null);
        model.addAttribute("voluntario", voluntario);
        return "voluntario_home";
    }
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
