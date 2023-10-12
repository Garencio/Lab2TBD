package com.lab1tbd.repositories;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


public abstract class Repository<Entity> {

    protected final Sql2o sql2o;
    private final String Tabla;

    protected Repository(Sql2o sql2o, String Tabla){
        this.sql2o = sql2o;
        this.Tabla = Tabla;
    }

    public Entity get(Long id, Class<Entity> entidad) {
        try (Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM " + Tabla + " WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(entidad);
        }
    }

    public void delete(Long id){
        try (Connection connection = sql2o.open()){
                connection.createQuery("DELETE  FROM " + Tabla + " WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public List<Entity> getAll(Class<Entity> entidad) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM " + Tabla).executeAndFetch(entidad);
        }
    }

}
