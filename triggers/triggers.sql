-- Trigger emergencia
CREATE OR REPLACE FUNCTION trigger_coordinador_insert_emergencia() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO coordinador_log (action, table_name, record_id)
VALUES ('Crear', 'Emergencia', NEW.id);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_coordinador_insert_emergencia
    AFTER INSERT ON Emergencia
    FOR EACH ROW
    EXECUTE FUNCTION trigger_coordinador_insert_emergencia();

CREATE OR REPLACE FUNCTION trigger_coordinador_update_emergencia() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO coordinador_log (action, table_name, record_id)
VALUES (NEW.estado, 'Emergencia', NEW.id);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_coordinador_update_emergencia
    AFTER UPDATE OF estado ON Emergencia
    FOR EACH ROW
    EXECUTE FUNCTION trigger_coordinador_update_emergencia();

-- Trigger tarea
CREATE OR REPLACE FUNCTION trigger_coordinador_insert_tarea() RETURNS TRIGGER AS $$
BEGIN
INSERT INTO coordinador_log (action, table_name, record_id)
VALUES ('Crear', 'Tarea', NEW.id);
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_coordinador_insert_tarea
    AFTER INSERT ON Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_coordinador_insert_tarea();

CREATE OR REPLACE FUNCTION trigger_coordinador_update_tarea() RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT nombre FROM EstadoTarea WHERE id = NEW.estadoTareaId) IN ('Iniciado', 'Finalizado') THEN
        INSERT INTO coordinador_log (action, table_name, record_id)
        VALUES ((SELECT nombre FROM EstadoTarea WHERE id = NEW.estadoTareaId), 'Tarea', NEW.id);
END IF;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER audit_coordinador_update_tarea
    AFTER UPDATE OF estadoTareaId ON Tarea
    FOR EACH ROW
    EXECUTE FUNCTION trigger_coordinador_update_tarea();
