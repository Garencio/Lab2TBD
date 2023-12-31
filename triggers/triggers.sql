CREATE OR REPLACE FUNCTION log_emergencia_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
        VALUES (NEW.coordinador_id, 'crear', 'emergencia', NEW.id, now());
RETURN NEW;
ELSIF (TG_OP = 'UPDATE') THEN
        IF (OLD.estado != NEW.estado) THEN
            IF (NEW.estado = 'Iniciada') THEN
                INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
                VALUES (NEW.coordinador_id, 'iniciar', 'emergencia', NEW.id, now());
            ELSIF (NEW.estado = 'Cancelada') THEN
                INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
                VALUES (NEW.coordinador_id, 'cancelar', 'emergencia', NEW.id, now());
            ELSIF (NEW.estado = 'Finalizada') THEN
                INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
                VALUES (NEW.coordinador_id, 'finalizar', 'emergencia', NEW.id, now());
END IF;
END IF;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$ LANGUAGE plpgsql;
   ---------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION log_tarea_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
        VALUES (NEW.coordinador_id, 'crear', 'tarea', NEW.id, now());
RETURN NEW;
ELSIF (TG_OP = 'UPDATE') THEN
        IF (OLD.estado_tarea_id != NEW.estado_tarea_id) THEN
            IF (NEW.estado_tarea_id = 2) THEN
                INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
                VALUES (NEW.coordinador_id, 'iniciar', 'tarea', NEW.id, now());
            ELSIF (NEW.estado_tarea_id = 3) THEN
                INSERT INTO coordinador_log(coordinador_id, action, table_name, record_id, timestamp)
                VALUES (NEW.coordinador_id, 'finalizar', 'tarea', NEW.id, now());
END IF;
END IF;
RETURN NEW;
END IF;
RETURN NULL;
END;
$$ LANGUAGE plpgsql;
---------------------------------------------
CREATE TRIGGER trigger_log_emergencia_changes
    AFTER INSERT OR UPDATE ON emergencia
                        FOR EACH ROW
                        EXECUTE FUNCTION log_emergencia_changes();
-----------------------------------------------
CREATE TRIGGER trigger_log_tarea_changes
    AFTER INSERT OR UPDATE ON tarea
                        FOR EACH ROW
                        EXECUTE FUNCTION log_tarea_changes();
