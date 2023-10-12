package com.lab1tbd.repositories;

import com.lab1tbd.models.TareaHabilidad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class TareaHabilidadRepository extends Repository<TareaHabilidad> {

    public TareaHabilidadRepository(Sql2o sql2o) {
        super(sql2o, "tarea_habilidad");
    }

    public Long createTareaHabilidad(TareaHabilidad tareaHabilidad) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO tarea_habilidad(tarea_id, eme_habilidad_id) VALUES (:tarea_id, :eme_habilidad_id)", true)
                    .bind(tareaHabilidad)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateTareaHabilidad(TareaHabilidad tareaHabilidad) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE tarea_habilidad SET tarea_id = :tarea_id, eme_habilidad_id = :eme_habilidad_id WHERE id = :id")
                    .bind(tareaHabilidad)
                    .executeUpdate();
        }
    }
}
