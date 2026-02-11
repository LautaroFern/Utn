CREATE TYPE estado_postulacion AS ENUM(
    'APROBADA',
    'POSTULADA',
    'RECHAZADA'
);

CREATE TYPE estado_convocatoria AS ENUM(
    'ABIERTA',
    'CERRADA'
);

CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL, /*evitar futuros errores por la ñ */
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE alumno (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    domicilio VARCHAR(300) NOT NULL,
    codigo_postal VARCHAR(20) NOT NULL,
    localidad VARCHAR(100) NOT NULL,
    provincia VARCHAR(100) NOT NULL, 
    /*CIUDAD EN LA QUE VIVE SU NUCLEO FAMILIAR*/
    ciudad_familia VARCHAR(100) NOT NULL,
    /*REFERENCIA A LA VIVIENDA EN LA QUE ESTA EL ESTUDIANTE*/
    vivienda VARCHAR(200) NOT NULL,
    /*CONDICION LABORAL DEL ESTUDIANTE*/
    condicion_laboral VARCHAR(200) NOT NULL,
    /*SALUD DEL ESTUDIANTE*/
    salud VARCHAR(200) NOT NULL,
    tiene_discapacidad BOOLEAN NOT NULL,
    discapacidad_detalle VARCHAR(300),
    CONSTRAINT fk_alumno_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE rol (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE usuario_rol (
    usuario_id BIGINT NOT NULL,
    rol_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, rol_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);

CREATE TABLE familiar (
    id BIGSERIAL PRIMARY KEY,
    /*CAMPO EL CUAL GUARDA LA REFERENCIA CON EL ALUMNO*/
    alumno_id BIGINT NOT NULL, 
    nombre VARCHAR (100) NOT NULL,
    apellido VARCHAR (100) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    parentesco_alumno VARCHAR(50) NOT NULL, 
    ocupacion VARCHAR(300) NOT NULL, 
    ingreso DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES alumno(id)
);

CREATE TABLE beca (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL,
    /*TIPO DE BECA (BASE-BIS)*/
    tipo_beca VARCHAR(20) NOT NULL,
    /*CASO DE SER UNA BECA BIS REQUERIRA QUE EL ESTUDIANTE ESTE CURSANDO UNA INGENIERIA*/
    requiere_ingenieria BOOLEAN NOT NULL
);

CREATE TABLE convocatoria (
    id BIGSERIAL PRIMARY KEY,
    beca_id BIGINT NOT NULL,
    anio INT NOT NULL,
    fecha_abierto TIMESTAMPTZ NOT NULL,
    fecha_cerrado TIMESTAMPTZ NOT NULL, 
    descripcion VARCHAR(200),
    estado estado_convocatoria NOT NULL,
    FOREIGN KEY(beca_id) REFERENCES beca(id),
    UNIQUE(beca_id, anio)
);

CREATE TABLE estado_academico (
    id BIGSERIAL PRIMARY KEY,
    alumno_id BIGINT NOT NULL,
    materias_aprobadas INT NOT NULL,
    materias_cursando INT NOT NULL,
    anio_ingreso INT NOT NULL,
    promedio DECIMAL(4,2) NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES alumno(id)
);

CREATE TABLE materia_cursando(
    id BIGSERIAL PRIMARY KEY,
    alumno_id BIGINT NOT NULL,
    nombre VARCHAR (100) NOT NULL,
    /* NIVEL EN EL QUE SE ENCUENTRA LA MATERIA QUE ESTA CURSANDO (Primer año Primer Cuatrimestre/ Primer año Segundo Cuatrimestre).... */
    nivel VARCHAR (50) NOT NULL,
    regimen VARCHAR (100) NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES alumno(id)
);

CREATE TABLE final_planificado(
    id BIGSERIAL PRIMARY KEY,
    alumno_id BIGINT NOT NULL,
    nombre_materia VARCHAR (100) NOT NULL,
    /* NIVEL EN EL QUE SE ENCUENTRA EL FINAL QUE ESTA RINDIENDO (Primer año Primer Cuatrimestre/ Primer año Segundo Cuatrimestre).... */
    nivel VARCHAR (50) NOT NULL,
    mes_mesa VARCHAR (20) NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES alumno(id)
);

/*TABLAS PIVOT*/

CREATE TABLE alumno_beca(
    id BIGSERIAL PRIMARY KEY,
    alumno_id BIGINT NOT NULL,
    beca_id BIGINT NOT NULL,
    convocatoria_id BIGINT NOT NULL,
    fecha_postulacion DATE NOT NULL,

    /* INDICA SI LA BECA ESTA APROBADA-POSTULADA-RECHAZADA*/
    estado_postulacion estado_postulacion NOT NULL,
    observaciones TEXT,

    FOREIGN KEY (alumno_id) REFERENCES alumno(id),
    FOREIGN KEY (beca_id) REFERENCES beca(id),
    FOREIGN KEY (convocatoria_id) REFERENCES convocatoria(id),

    UNIQUE(alumno_id, beca_id, convocatoria_id)
);