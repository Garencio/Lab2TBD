CREATE EXTENSION postgis;
-- Tabla Institucion
CREATE TABLE institucion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    contacto VARCHAR(255)
);
-- Tabla EstadoTarea
CREATE TABLE estado_tarea (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);
-- Tabla Emergencia
CREATE TABLE emergencia (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_inicio TIMESTAMP,
    ubicacion geometry(Point, 4326),
    institucion_id INTEGER REFERENCES institucion(id)
);
-- Tabla Tarea
CREATE TABLE tarea (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_asignacion TIMESTAMP,
    ubicacion geometry(Point, 4326),
    estado_tarea_id INTEGER REFERENCES estado_tarea(id),
    emergencia_id INTEGER REFERENCES emergencia(id)
);
-- Tabla Coordinador
CREATE TABLE coordinador (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(50),
    direccion VARCHAR(255),
    fecha_registro TIMESTAMP
);
-- Tabla Habilidad
CREATE TABLE habilidad (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);
-- Tabla EmeHabilidad
CREATE TABLE eme_habilidad (
    id SERIAL PRIMARY KEY,
    emergencia_id INTEGER REFERENCES emergencia(id),
    habilidad_id INTEGER REFERENCES habilidad(id)
);
-- Tabla Voluntario
CREATE TABLE voluntario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(50),
    direccion VARCHAR(255),
    fecha_registro TIMESTAMP
);
-- Tabla Ranking
CREATE TABLE ranking (
    id SERIAL PRIMARY KEY,
    voluntario_id INTEGER REFERENCES voluntario(id),
    tarea_id INTEGER REFERENCES tarea(id),
    puntuacion INTEGER
);
-- Tabla TareaHabilidad
CREATE TABLE tarea_habilidad (
    id SERIAL PRIMARY KEY,
    tarea_id INTEGER REFERENCES tarea(id),
    eme_habilidad_id INTEGER REFERENCES eme_habilidad(id)
);
-- Tabla VolHabilidad
CREATE TABLE vol_habilidad (
    id SERIAL PRIMARY KEY,
    voluntario_id INTEGER REFERENCES voluntario(id),
    habilidad_id INTEGER REFERENCES habilidad(id)
);