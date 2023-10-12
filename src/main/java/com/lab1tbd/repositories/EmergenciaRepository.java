package com.lab1tbd.repositories;

import com.lab1tbd.models.Emergencia;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class EmergenciaRepository extends Repository<Emergencia> {

    public EmergenciaRepository(Sql2o sql2o) {
        super(sql2o, "emergencia");
    }

    public Long createEmergencia(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO emergencia(nombre, descripcion, fecha, ubicacion) VALUES (:nombre, :descripcion, :fecha, :ubicacion)", true)
                    .bind(emergencia)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateEmergencia(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE emergencia SET nombre = :nombre, descripcion = :descripcion, fecha = :fecha, ubicacion = :ubicacion WHERE id = :id")
                    .bind(emergencia)
                    .executeUpdate();
        }
    }
}

