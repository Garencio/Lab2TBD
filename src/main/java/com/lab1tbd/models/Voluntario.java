package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voluntario {

    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;
    private LocalDateTime fecha_registro;

}

