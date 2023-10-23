package com.lab1tbd.repositories;

import com.lab1tbd.models.Tarea;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class TareaRepository extends Repository<Tarea> {

    public TareaRepository(Sql2o sql2o) {
        super(sql2o, "tarea");
    }

    public Long createTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO tarea(nombre, descripcion, estado, emergencia_id) VALUES (:nombre, :descripcion, :estado, :emergencia_id)", true)
                    .bind(tarea)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE tarea SET nombre = :nombre, descripcion = :descripcion, estado = :estado, emergencia_id = :emergencia_id WHERE id = :id")
                    .bind(tarea)
                    .executeUpdate();
        }
    }

    public Tarea findTareaById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM tarea WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
        }
    }

    public void deleteTareaById(Long id) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM tarea WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}
