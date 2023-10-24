package com.lab1tbd.repositories;

import com.lab1tbd.models.Emergencia;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@org.springframework.stereotype.Repository
public class EmergenciaRepository extends Repository<Emergencia> {

    public EmergenciaRepository(Sql2o sql2o) {
        super(sql2o, "emergencia");
    }

    public Long createEmergencia(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO emergencia(nombre, descripcion, fecha_inicio, ubicacion) VALUES (:nombre, :descripcion, :fecha, :ubicacion)", true)
                    .bind(emergencia)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateEmergencia(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE emergencia SET nombre = :nombre, descripcion = :descripcion, fecha_inicio = :fecha, ubicacion = :ubicacion WHERE id = :id")
                    .bind(emergencia)
                    .executeUpdate();
        }
    }

    public Emergencia findEmergenciaById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT id, nombre, descripcion, estado, ubicacion, institucion_id FROM emergencia WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
        }
    }

    public void deleteEmergenciaById(Long id) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM emergencia WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public List<Emergencia> findAll() {
        try (Connection connection = sql2o.open()) {
            List<Emergencia> emergencias = connection.createQuery("SELECT id, nombre, descripcion, estado, institucion_id FROM emergencia")
                    .executeAndFetch(Emergencia.class);

            for (Emergencia emergencia : emergencias) {
                System.out.println("ID: " + emergencia.getId());
                System.out.println("Nombre: " + emergencia.getNombre());
                System.out.println("Descripción: " + emergencia.getDescripcion());
                System.out.println("Estado: " + emergencia.getEstado());

                System.out.println("Institución ID: " + emergencia.getInstitucion_id());
                System.out.println("-------------------------------");
            }

            return emergencias;
        }
    }



}

