package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emergencia {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_inicio;
    private Double latitud;
    private Double longitud;
    private Point ubicacion;
    private Long institucion_id;
    private String estado;
    private Long coordinador_id;

}

