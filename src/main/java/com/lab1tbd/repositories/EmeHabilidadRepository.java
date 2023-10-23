package com.lab1tbd.repositories;

import com.lab1tbd.models.EmeHabilidad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class EmeHabilidadRepository extends Repository<EmeHabilidad> {

    public EmeHabilidadRepository(Sql2o sql2o) {
        super(sql2o, "eme_habilidad");
    }

    public Long createEmeHabilidad(EmeHabilidad emeHabilidad) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO eme_habilidad(emergencia_id, habilidad_id) VALUES (:emergencia_id, :habilidad_id)", true)
                    .bind(emeHabilidad)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateEmeHabilidad(EmeHabilidad emeHabilidad) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE eme_habilidad SET emergencia_id = :emergencia_id, habilidad_id = :habilidad_id WHERE id = :id")
                    .bind(emeHabilidad)
                    .executeUpdate();
        }
    }

    public EmeHabilidad findEmeHabilidadById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM eme_habilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmeHabilidad.class);
        }
    }

    public void deleteEmeHabilidadById(Long id) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM eme_habilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}

