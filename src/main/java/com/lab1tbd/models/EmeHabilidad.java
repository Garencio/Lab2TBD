package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmeHabilidad {

    private Long id;
    private Long emergenciaId;
    private Long habilidadId;

}

