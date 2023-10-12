package com.lab1tbd.repositories;

import com.lab1tbd.models.Institucion;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class InstitucionRepository extends Repository<Institucion> {

    public InstitucionRepository(Sql2o sql2o) {
        super(sql2o, "institucion");
    }

    public Long createInstitucion(Institucion institucion) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO institucion(nombre, direccion, contacto) VALUES (:nombre, :direccion, :contacto)", true)
                    .bind(institucion)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateInstitucion(Institucion institucion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE institucion SET nombre = :nombre, direccion = :direccion, contacto = :contacto WHERE id = :id")
                    .bind(institucion)
                    .executeUpdate();
        }
    }
}

