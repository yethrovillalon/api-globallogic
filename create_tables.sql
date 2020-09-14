create sequence usuario_seq;

CREATE TABLE usuario ( 
   id_usuario bigint default usuario_seq.nextval primary key NOT NULL, 
   nombre VARCHAR(20) NOT NULL, 
   correo VARCHAR(50) NOT NULL, 
   contrasena VARCHAR(50) NOT NULL, 
   fecha_creacion DATE,
   fecha_modificacion DATE,
   last_login DATE,
   activo BOOLEAN default TRUE,
   token clob,
   UNIQUE KEY correo (correo)
);

create sequence telefono_seq;

CREATE TABLE telefono ( 
   id_telefono bigint default telefono_seq.nextval primary key NOT NULL, 
   id_usuario bigint NOT NULL, 
   numero VARCHAR(15) NOT NULL, 
   codigo_ciudad VARCHAR(5) NOT NULL,
   codigo_pais VARCHAR(5) NOT NULL 
);
