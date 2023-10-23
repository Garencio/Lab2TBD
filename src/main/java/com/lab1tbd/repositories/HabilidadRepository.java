package com.lab1tbd.repositories;

import com.lab1tbd.models.Habilidad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class HabilidadRepository extends  Repository<Habilidad> {

    public HabilidadRepository(Sql2o sql2o){
        super(sql2o, "habilidad");
    }

    public Long createHabilidad(Habilidad habilidad){
        try (Connection connection = sql2o.open()) {
            return (Long) connection.createQuery("INSERT INTO habilidad(nombre, descripcion) VALUES (:nombre, :descripcion)", true)
                    .bind(habilidad)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateHabilidad(Habilidad habilidad){
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE habilidad SET nombre = :nombre, descripcion = :descripcion")
                    .bind(habilidad)
                    .executeUpdate();
        }
    }

    public Habilidad findHabilidadById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM habilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
        }
    }

    public void deleteHabilidadById(Long id) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM habilidad WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}
