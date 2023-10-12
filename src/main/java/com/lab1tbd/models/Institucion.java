package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institucion {

    private Long id;
    private String nombre;
    private String direccion;
    private String contacto;

}

