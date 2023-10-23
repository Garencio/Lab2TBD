CREATE TABLE queries_log (
                             id BIGSERIAL PRIMARY KEY,
                             usuario VARCHAR(255),
                             tabla_afectada VARCHAR(255),
                             tipo_operacion VARCHAR(50),
                             query_text TEXT,
                             timestamp TIMESTAMP DEFAULT NOW()
);
CREATE OR REPLACE FUNCTION log_queries()
RETURNS TRIGGER AS $$
BEGIN
INSERT INTO queries_log(usuario, tabla_afectada, tipo_operacion, query_text, timestamp)
VALUES (current_user, TG_TABLE_NAME, TG_OP, current_query(), now());
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_log_emergencia_after_insert
    AFTER INSERT ON emergencia
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_emergencia_after_update
    AFTER UPDATE ON emergencia
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_emergencia_after_delete
    AFTER DELETE ON emergencia
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_tarea_after_insert
    AFTER INSERT ON tarea
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_tarea_after_update
    AFTER UPDATE ON tarea
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_tarea_after_delete
    AFTER DELETE ON tarea
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_coordinador_after_insert
    AFTER INSERT ON coordinador
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_coordinador_after_update
    AFTER UPDATE ON coordinador
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_coordinador_after_delete
    AFTER DELETE ON coordinador
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_institucion_after_insert
    AFTER INSERT ON institucion
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_institucion_after_update
    AFTER UPDATE ON institucion
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_institucion_after_delete
    AFTER DELETE ON institucion
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_estado_tarea_after_insert
    AFTER INSERT ON estado_tarea
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_estado_tarea_after_update
    AFTER UPDATE ON estado_tarea
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_estado_tarea_after_delete
    AFTER DELETE ON estado_tarea
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_habilidad_after_insert
    AFTER INSERT ON habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_habilidad_after_update
    AFTER UPDATE ON habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_habilidad_after_delete
    AFTER DELETE ON habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_eme_habilidad_after_insert
    AFTER INSERT ON eme_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_eme_habilidad_after_update
    AFTER UPDATE ON eme_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_eme_habilidad_after_delete
    AFTER DELETE ON eme_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_voluntario_after_insert
    AFTER INSERT ON voluntario
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_voluntario_after_update
    AFTER UPDATE ON voluntario
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_voluntario_after_delete
    AFTER DELETE ON voluntario
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_ranking_after_insert
    AFTER INSERT ON ranking
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_ranking_after_update
    AFTER UPDATE ON ranking
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_ranking_after_delete
    AFTER DELETE ON ranking
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_tarea_habilidad_after_insert
    AFTER INSERT ON tarea_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_tarea_habilidad_after_update
    AFTER UPDATE ON tarea_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_tarea_habilidad_after_delete
    AFTER DELETE ON tarea_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_vol_habilidad_after_insert
    AFTER INSERT ON vol_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_vol_habilidad_after_update
    AFTER UPDATE ON vol_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();

CREATE TRIGGER trigger_log_vol_habilidad_after_delete
    AFTER DELETE ON vol_habilidad
    FOR EACH ROW
    EXECUTE FUNCTION log_queries();
