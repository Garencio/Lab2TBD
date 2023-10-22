-- Coordinador
-- Trigger INSERT
CREATE OR REPLACE FUNCTION trigger_insert_coordinador() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO audit_log (operation, table_name, record_id, new_data)
    VALUES ('INSERT', 'Coordinador', NEW.id, row_to_json(NEW)::text);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_coordinador
AFTER INSERT ON Coordinador
FOR EACH ROW
EXECUTE FUNCTION trigger_insert_coordinador();

-- Trigger UPDATE
CREATE OR REPLACE FUNCTION trigger_update_coordinador() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
    VALUES ('UPDATE', 'Coordinador', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_coordinador
AFTER UPDATE ON Coordinador
FOR EACH ROW
EXECUTE FUNCTION trigger_update_coordinador();

-- Trigger DELETE
CREATE OR REPLACE FUNCTION trigger_delete_coordinador() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO audit_log (operation, table_name, record_id, old_data)
    VALUES ('DELETE', 'Coordinador', OLD.id, row_to_json(OLD)::text);
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_coordinador
AFTER DELETE ON Coordinador
FOR EACH ROW
EXECUTE FUNCTION trigger_delete_coordinador();

-- EmeHabilidad
-- Trigger para operaciones INSERT en la tabla EmeHabilidad
CREATE OR REPLACE FUNCTION trigger_insert_eme_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Eme_Habilidad', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_eme_habilidad
    AFTER INSERT ON Eme_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_eme_habilidad();

-- Trigger para operaciones UPDATE en la tabla EmeHabilidad
CREATE OR REPLACE FUNCTION trigger_update_eme_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Eme_Habilidad', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_eme_habilidad
    AFTER UPDATE ON Eme_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_eme_habilidad();

-- Trigger para operaciones DELETE en la tabla EmeHabilidad
CREATE OR REPLACE FUNCTION trigger_delete_eme_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Eme_Habilidad', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_eme_habilidad
    AFTER DELETE ON Eme_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_eme_habilidad();
-- Emergencia
-- Trigger para operaciones INSERT en la tabla Emergencia
CREATE OR REPLACE FUNCTION trigger_insert_emergencia() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Emergencia', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_emergencia
    AFTER INSERT ON Emergencia
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_emergencia();

-- Trigger para operaciones UPDATE en la tabla Emergencia
CREATE OR REPLACE FUNCTION trigger_update_emergencia() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Emergencia', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_emergencia
    AFTER UPDATE ON Emergencia
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_emergencia();

-- Trigger para operaciones DELETE en la tabla Emergencia
CREATE OR REPLACE FUNCTION trigger_delete_emergencia() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Emergencia', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_emergencia
    AFTER DELETE ON Emergencia
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_emergencia();
-- EstadoTarea
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_estado_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Estado_Tarea', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_estado_tarea
    AFTER INSERT ON Estado_Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_estado_tarea();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_estado_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Estado_Tarea', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_estado_tarea
    AFTER UPDATE ON Estado_Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_estado_tarea();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_estado_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Estado_Tarea', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_estadotarea
    AFTER DELETE ON Estado_Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_estado_tarea();
-- Habilidad
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Habilidad', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_habilidad
    AFTER INSERT ON Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_habilidad();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Habilidad', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_habilidad
    AFTER UPDATE ON Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_habilidad();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Habilidad', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_habilidad
    AFTER DELETE ON Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_habilidad();
-- Institucion
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_institucion() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Institucion', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_institucion
    AFTER INSERT ON Institucion
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_institucion();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_institucion() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Institucion', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_institucion
    AFTER UPDATE ON Institucion
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_institucion();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_institucion() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Institucion', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_institucion
    AFTER DELETE ON Institucion
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_institucion();
-- Ranking
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_ranking() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Ranking', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_ranking
    AFTER INSERT ON Ranking
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_ranking();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_ranking() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Ranking', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_ranking
    AFTER UPDATE ON Ranking
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_ranking();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_ranking() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Ranking', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_ranking
    AFTER DELETE ON Ranking
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_ranking();
-- Tarea
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Tarea', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_tarea
    AFTER INSERT ON Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_tarea();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Tarea', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_tarea
    AFTER UPDATE ON Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_tarea();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Tarea', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_tarea
    AFTER DELETE ON Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_tarea();
-- TareaHabilidad
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_tarea_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Tarea_Habilidad', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_tarea_habilidad
    AFTER INSERT ON Tarea_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_tarea_habilidad();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_tarea_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Tarea_Habilidad', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_tarea_habilidad
    AFTER UPDATE ON Tarea_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_tarea_habilidad();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_tarea_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Tarea_Habilidad', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_tarea_habilidad
    AFTER DELETE ON Tarea_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_tarea_habilidad();
-- VolHabilidad
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_vol_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Vol_Habilidad', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_vol_habilidad
    AFTER INSERT ON Vol_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_vol_habilidad();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_vol_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Vol_Habilidad', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_vol_habilidad
    AFTER UPDATE ON Vol_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_vol_habilidad();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_vol_habilidad() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Vol_Habilidad', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_vol_habilidad
    AFTER DELETE ON Vol_Habilidad
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_vol_habilidad();
-- Voluntario
-- Trigger para operaciones INSERT
CREATE OR REPLACE FUNCTION trigger_insert_voluntario() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, new_data)
VALUES ('INSERT', 'Voluntario', NEW.id, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_insert_voluntario
    AFTER INSERT ON Voluntario
    FOR EACH ROW
    EXECUTE FUNCTION trigger_insert_voluntario();

-- Trigger para operaciones UPDATE
CREATE OR REPLACE FUNCTION trigger_update_voluntario() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data, new_data)
VALUES ('UPDATE', 'Voluntario', NEW.id, row_to_json(OLD)::text, row_to_json(NEW)::text);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_update_voluntario
    AFTER UPDATE ON Voluntario
    FOR EACH ROW
    EXECUTE FUNCTION trigger_update_voluntario();

-- Trigger para operaciones DELETE
CREATE OR REPLACE FUNCTION trigger_delete_voluntario() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO audit_log (operation, table_name, record_id, old_data)
VALUES ('DELETE', 'Voluntario', OLD.id, row_to_json(OLD)::text);
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_delete_voluntario
    AFTER DELETE ON Voluntario
    FOR EACH ROW
    EXECUTE FUNCTION trigger_delete_voluntario();
