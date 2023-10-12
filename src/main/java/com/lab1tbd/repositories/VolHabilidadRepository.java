package com.lab1tbd.repositories;

import com.lab1tbd.models.VolHabilidad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class VolHabilidadRepository extends Repository<VolHabilidad> {

    public VolHabilidadRepository(Sql2o sql2o) {
        super(sql2o, "vol_habilidad");
    }

    public Long createVolHabilidad(VolHabilidad volHabilidad) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO vol_habilidad(voluntario_id, habilidad_id) VALUES (:voluntario_id, :habilidad_id)", true)
                    .bind(volHabilidad)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateVolHabilidad(VolHabilidad volHabilidad) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE vol_habilidad SET voluntario_id = :voluntario_id, habilidad_id = :habilidad_id WHERE id = :id")
                    .bind(volHabilidad)
                    .executeUpdate();
        }
    }
}
