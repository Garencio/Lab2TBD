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
import java.util.Map;


@CrossOrigin(origins = "http://localhost:5173")
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
        String username = principal.getName();
        Voluntario voluntario = voluntarioService.findVoluntarioByEmail(username);
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
            Long id = voluntarioService.saveVoluntario(voluntario);
            voluntario.setId(id);
            return ResponseEntity.ok(voluntario);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginVoluntario(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("contrasena");

        Voluntario voluntario = voluntarioService.findVoluntarioByEmail(email);
        if (voluntario == null || !bCryptPasswordEncoder.matches(password, voluntario.getContrasena())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        String token = jwtService.generateTokenForVoluntario(voluntario);
        return ResponseEntity.ok(token);
    }

}
