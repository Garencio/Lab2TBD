package com.lab1tbd.repositories;

import com.lab1tbd.models.Coordinador;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class CoordinadorRepository extends Repository<Coordinador> {

    public CoordinadorRepository(Sql2o sql2o) {
        super(sql2o, "coordinador");
    }

    public Long createCoordinador(Coordinador coordinador){
        try (Connection connection = sql2o.open()){
            return (Long) connection.createQuery("INSERT INTO coordinador(nombre, email, telefono, direccion, fechaRegistro) VALUES (:nombre, :email, :telefono, :direccion, :fechaRegistro)", true)
                    .bind(coordinador)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateCoordinador(Coordinador coordinador){
        try (Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE coordinador SET nombre = :nombre, email = :email, telefono = :telefono, direccion = :direccion WHERE id = :id")
                    .bind(coordinador)
                    .executeUpdate();
        }
    }

    public Coordinador findCoordinadorByEmail(String email) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM coordinador WHERE email = :email")
                    .addParameter("email", email)
                    .executeAndFetchFirst(Coordinador.class);
        }
    }
}
