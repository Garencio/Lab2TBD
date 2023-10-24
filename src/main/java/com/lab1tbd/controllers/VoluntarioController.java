package com.lab1tbd.controllers;

import com.lab1tbd.models.Emergencia;
import com.lab1tbd.models.Tarea;
import com.lab1tbd.models.Voluntario;
import com.lab1tbd.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Autowired
    private EmergenciaService emergenciaService;

    @Autowired
    private TareaService tareaService;

    @Autowired
    private RankingService rankingService;

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

    @GetMapping("/listado-emergencias-y-tareas")
    public Map<String, Object> listadoEmergenciasYTareas() {
        List<Emergencia> emergencias = emergenciaService.getAllEmergencias();
        System.out.println("Emergencias obtenidas: " + emergencias);

        Map<Long, List<Tarea>> emergenciaTareas = new HashMap<>();
        Map<Long, Integer> tareaVoluntarios = new HashMap<>();

        for (Emergencia emergencia : emergencias) {
            List<Tarea> tareas = tareaService.getTareasByEmergenciaId(emergencia.getId());
            System.out.println("Tareas para la emergencia " + emergencia.getNombre() + " (ID: " + emergencia.getId() + "): " + tareas);
            emergenciaTareas.put(emergencia.getId(), tareas);

            for (Tarea tarea : tareas) {
                int cantidadVoluntarios = rankingService.getCantidadVoluntariosPorTarea(tarea.getId());
                System.out.println("Cantidad de voluntarios para la tarea " + tarea.getNombre() + " (ID: " + tarea.getId() + "): " + cantidadVoluntarios);
                tareaVoluntarios.put(tarea.getId(), cantidadVoluntarios);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("emergencias", emergencias);
        result.put("emergenciaTareas", emergenciaTareas);
        result.put("tareaVoluntarios", tareaVoluntarios);

        return result;
    }

}



