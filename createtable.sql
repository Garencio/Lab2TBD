CREATE EXTENSION IF NOT EXISTS postgis;

-- Tabla Region
CREATE TABLE region (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    area GEOMETRY(MULTIPOLYGON, 4326)
);

-- Tabla Log del Coordinador
CREATE TABLE coordinador_log (
    id BIGSERIAL PRIMARY KEY,
    coordinador_id BIGINT,
    action VARCHAR(255),
    table_name VARCHAR(255),
    record_id BIGINT,
    timestamp TIMESTAMP DEFAULT NOW()
);
-- Tabla Coordinador
CREATE TABLE coordinador (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(50),
    direccion VARCHAR(255)
);

-- Tabla Institucion
CREATE TABLE institucion (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    contacto VARCHAR(255)
);
-- Tabla EstadoTarea
CREATE TABLE estado_tarea (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);
-- Tabla Emergencia
CREATE TABLE emergencia (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(255),
    fecha_inicio TIMESTAMP,
    ubicacion geometry(Point, 4326),
    institucion_id INTEGER REFERENCES institucion(id),
    coordinador_id BIGINT REFERENCES coordinador(id)
);
-- Tabla Tarea
CREATE TABLE tarea (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_asignacion TIMESTAMP,
    ubicacion geometry(Point, 4326),
    estado_tarea_id INTEGER REFERENCES estado_tarea(id),
    emergencia_id INTEGER REFERENCES emergencia(id),
    coordinador_id BIGINT REFERENCES coordinador(id)
);
-- Tabla Habilidad
CREATE TABLE habilidad (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);
-- Tabla EmeHabilidad
CREATE TABLE eme_habilidad (
    id BIGSERIAL PRIMARY KEY,
    emergencia_id INTEGER REFERENCES emergencia(id),
    habilidad_id INTEGER REFERENCES habilidad(id)
);
-- Tabla Voluntario
CREATE TABLE voluntario (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(50),
    direccion VARCHAR(255)
);
-- Tabla Ranking
CREATE TABLE ranking (
    id BIGSERIAL PRIMARY KEY,
    voluntario_id INTEGER REFERENCES voluntario(id),
    tarea_id INTEGER REFERENCES tarea(id),
    puntuacion INTEGER
);
-- Tabla TareaHabilidad
CREATE TABLE tarea_habilidad (
    id BIGSERIAL PRIMARY KEY,
    tarea_id INTEGER REFERENCES tarea(id),
    eme_habilidad_id INTEGER REFERENCES eme_habilidad(id)
);
-- Tabla VolHabilidad
CREATE TABLE vol_habilidad (
    id BIGSERIAL PRIMARY KEY,
    voluntario_id INTEGER REFERENCES voluntario(id),
    habilidad_id INTEGER REFERENCES habilidad(id)
);