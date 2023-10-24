package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_asignacion;
    private Point ubicacion;
    private Long estado_tarea_id;
    private Long emergencia_id;
    private Long coordinador_id;


}


