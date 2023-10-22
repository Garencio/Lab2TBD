package com.lab1tbd.repositories;

import com.lab1tbd.models.Voluntario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class VoluntarioRepository  extends Repository<Voluntario>{

    public VoluntarioRepository(Sql2o sql2o){
        super(sql2o, "voluntario");
    }

    private static final Logger logger = LoggerFactory.getLogger(VoluntarioRepository.class);

    public Long createVoluntario(Voluntario voluntario) {
        try (Connection connection = sql2o.open()) {
            return (Long) connection.createQuery("INSERT INTO voluntario(nombre, email, contrasena, telefono, direccion) VALUES (:nombre, :email, :contrasena, :telefono, :direccion)", true)
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

        logger.info("Buscando voluntario por email: {}", email);

        try (Connection connection = sql2o.open()) {
            Voluntario result = connection.createQuery("SELECT * FROM voluntario WHERE email = :email")
                    .addParameter("email", email)
                    .executeAndFetchFirst(Voluntario.class);

            if(result != null) {
                logger.info("Voluntario encontrado con ID: {}", result.getId());
            } else {
                logger.warn("No se encontró un voluntario con el email: {}", email);
            }

            return result;
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
