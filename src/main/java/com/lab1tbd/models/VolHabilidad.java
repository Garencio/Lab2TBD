package com.lab1tbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolHabilidad {

    private Long id;
    private Long voluntarioId;
    private Long habilidadId;


}

