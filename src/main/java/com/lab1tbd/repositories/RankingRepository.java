package com.lab1tbd.repositories;

import com.lab1tbd.models.Ranking;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@org.springframework.stereotype.Repository
public class RankingRepository extends Repository<Ranking> {

    public RankingRepository(Sql2o sql2o) {
        super(sql2o, "ranking");
    }

    public Long createRanking(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            return (Long) conn.createQuery("INSERT INTO ranking(voluntario_id, tarea_id, puntaje) VALUES (:voluntario_id, :tarea_id, :puntaje)", true)
                    .bind(ranking)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateRanking(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE ranking SET voluntario_id = :voluntario_id, tarea_id = :tarea_id, puntaje = :puntaje WHERE id = :id")
                    .bind(ranking)
                    .executeUpdate();
        }
    }

    public Ranking findRankingById(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM ranking WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
        }
    }


    public void deleteRankingById(Long id) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM ranking WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public int countVoluntariosByTareaId(Long tareaId) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT COUNT(*) FROM ranking WHERE tarea_id = :tareaId";
            return con.createQuery(sql)
                    .addParameter("tareaId", tareaId)
                    .executeScalar(Integer.class);
        }
    }


}
