package com.lab1tbd.repositories;

import com.lab1tbd.models.EstadoTarea;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class EstadoTareaRepository extends Repository<EstadoTarea> {

    public EstadoTareaRepository(Sql2o sql2o) {
        super(sql2o, "estado_tarea");
    }

    public Long createEstadoTarea(EstadoTarea estadoTarea) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO estado_tarea(descripcion) VALUES (:descripcion)", true)
                    .bind(estadoTarea)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateEstadoTarea(EstadoTarea estadoTarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE estado_tarea SET descripcion = :descripcion WHERE id = :id")
                    .bind(estadoTarea)
                    .executeUpdate();
        }
    }
}
