package com.lab1tbd.repositories;

import com.lab1tbd.models.Voluntario;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class VoluntarioRepository  extends Repository<Voluntario>{

    public VoluntarioRepository(Sql2o sql2o){
        super(sql2o, "voluntario");
    }

    public Long createVoluntario(Voluntario voluntario) {
        try (Connection connection = sql2o.open()) {
            return (Long) connection.createQuery("INSERT INTO voluntario(nombre, email, contrasena, telefono, direccion, fechaRegistro) VALUES (:nombre, :email, :contrasena, :telefono, :direccion, :fechaRegistro)", true)
                    .bind(voluntario)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateVoluntario(Voluntario voluntario) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("UPDATE voluntario SET nombre = :nombre, email = :email, telefono = :telefono, direccion = :direccion WHERE id = :id")
                    .bind(voluntario)
                    .executeUpdate();
        }
    }

    public Voluntario findVoluntarioByEmail(String email) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM voluntario WHERE email = :email")
                    .addParameter("email", email)
                    .executeAndFetchFirst(Voluntario.class);
        }
    }

    public Voluntario findVoluntarioById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM voluntario WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
        }
    }

    public void deleteVoluntarioById(Long id) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM voluntario WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}
