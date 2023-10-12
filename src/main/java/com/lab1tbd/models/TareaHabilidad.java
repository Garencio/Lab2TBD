package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaHabilidad {

    private Long id;
    private Long tareaId;
    private Long emeHabilidadId;

}

