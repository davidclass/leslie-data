-- ******************************************************************************
-- Descripcion :Script para creacion de las secuencias de las tablas
--
-- Author      : davidclass1
-- Created     : 22/03/2017 12:43:06 p.m.
-- Proyecto    : NN.
-- Responsable :
-- RDC         :
--
-- Revisiones  :
-- Fecha      Autor       Motivo del cambio                             
-- ------------------------------------------------------------------------------
-- 22/03/2017 davidclass1 Script para creacion de las secuencias de las tablas
-- ******************************************************************************

-- Secuencias

-- SECUENCIA SCTR_P
CREATE SEQUENCE SEQ_SCTRP_AUTO_INCR
START WITH 1
INCREMENT BY 1;

-- SECUENCIA SCTR_S
CREATE SEQUENCE SEQ_SCTRS_AUTO_INCR
START WITH 1
INCREMENT BY 1;

-- SECUENCIA SCTR_S
CREATE SEQUENCE SEQ_CARNETS_AUTO_INCR
START WITH 1
INCREMENT BY 1;

-- SECUENCIA DOCUMENTO
CREATE SEQUENCE SEQ_DOCUMENTO_AUTO_INCR
START WITH 1
INCREMENT BY 1;

-- SECUENCIA INDUCCION
CREATE SEQUENCE SEQ_INDUCCION_AUTO_INCR
START WITH 1
INCREMENT BY 1;

-- SECUENCIA COLABORADOR
CREATE SEQUENCE SEQ_COLABORADOR_AUTO_INCR
START WITH 1
INCREMENT BY 1;



-- Tablas
CREATE TABLE SCTRP (
  id integer NOT NULL DEFAULT nextval('SEQ_SCTRP_AUTO_INCR'::regclass),
  codigo character varying(50) DEFAULT NULL,
  emision date DEFAULT NULL,
  vencimiento date DEFAULT NULL
);

CREATE TABLE SCTRS (
  id integer NOT NULL DEFAULT nextval('SEQ_SCTRS_AUTO_INCR'::regclass),
  codigo character varying(50) DEFAULT NULL,
  emision date DEFAULT NULL,
  vencimiento date DEFAULT NULL
);

CREATE TABLE CARNETS (
  id integer NOT NULL DEFAULT nextval('SEQ_SCTRS_AUTO_INCR'::regclass),
  codigo character varying(20) DEFAULT NULL,
  emision date DEFAULT NULL,
  vencimiento date DEFAULT NULL
);

CREATE TABLE DOCUMENTOS (
  id integer NOT NULL DEFAULT nextval('SEQ_DOCUMENTO_AUTO_INCR'::regclass),
  nombre character varying(5) DEFAULT NULL
);

CREATE TABLE INDUCCIONES (
  id integer NOT NULL DEFAULT nextval('SEQ_INDUCCION_AUTO_INCR'::regclass),
  codigo character varying(20) DEFAULT NULL,
  emision date DEFAULT NULL,
  vencimiento date DEFAULT NULL
);

CREATE TABLE COLABORADORES (
  id integer NOT NULL DEFAULT nextval('SEQ_COLABORADOR_AUTO_INCR'::regclass),
  nombre character varying(75) DEFAULT NULL,
  apellido character varying(75) DEFAULT NULL,
  numero_doc character varying(12) DEFAULT NULL,
  empresa character varying(15) DEFAULT NULL,  
  foto character varying(255) DEFAULT NULL,
  fech_nac date DEFAULT NULL,
  edad character varying(2) DEFAULT NULL,
  sctrp_id integer DEFAULT NULL,
  sctrs_id integer DEFAULT NULL,
  carnets_id integer DEFAULT NULL,
  documento_id integer DEFAULT NULL,
  induccion_id integer DEFAULT NULL
);



-- Constraint
ALTER TABLE public.sctrp
  ADD CONSTRAINT "PK_Sctrp" PRIMARY KEY (id)
;

ALTER TABLE public.sctrs
  ADD CONSTRAINT "PK_Sctrs" PRIMARY KEY (id)
;

ALTER TABLE public.carnets
  ADD CONSTRAINT "PK_Carnets" PRIMARY KEY (id)
;

ALTER TABLE public.documentos
  ADD CONSTRAINT "PK_Documento" PRIMARY KEY (id)
;

ALTER TABLE public.inducciones
  ADD CONSTRAINT "PK_Induccion" PRIMARY KEY (id)
;

ALTER TABLE public.colaboradores
    ADD CONSTRAINT "PK_Colaborador" PRIMARY KEY (id),
    ADD CONSTRAINT "FK_Sctrp_id" FOREIGN KEY (sctrp_id) REFERENCES public.sctrp(id),
    ADD CONSTRAINT "FK_Sctrs_id" FOREIGN KEY (sctrs_id) REFERENCES public.sctrs(id),
    ADD CONSTRAINT "FK_Carnets_id" FOREIGN KEY (carnets_id) REFERENCES public.carnets(id),
    ADD CONSTRAINT "FK_Documento_id" FOREIGN KEY (documento_id) REFERENCES public.documentos(id),    
    ADD CONSTRAINT "FK_Induccion_id" FOREIGN KEY (induccion_id) REFERENCES public.inducciones(id)
;


-- SECUENCIA USERS
CREATE SEQUENCE SEQ_USER_AUTO_INCR
START WITH 1
INCREMENT BY 1;

-- SECUENCIA AUTHORITIES
CREATE SEQUENCE SEQ_AUTHORITY_AUTO_INCR
START WITH 1
INCREMENT BY 1;


-- Tables
CREATE TABLE public.users
(
    id integer NOT NULL DEFAULT nextval('SEQ_USER_AUTO_INCR'::regclass),
    username character varying(45) NOT NULL,
    password character varying(60) NOT NULL,
    enabled smallint NOT NULL DEFAULT 1
);

CREATE TABLE public.authorities
(
    id integer NOT NULL DEFAULT nextval('SEQ_AUTHORITY_AUTO_INCR'::regclass),
    user_id integer NOT NULL,
    authority character varying(45) NOT NULL
);


-- Constraint
ALTER TABLE public.users
  ADD CONSTRAINT "PK_Users" PRIMARY KEY (id),
  ADD CONSTRAINT "Unique_key" UNIQUE (username)
;

ALTER TABLE public.authorities
  ADD CONSTRAINT "PK_Authoritiess" PRIMARY KEY (id),
  ADD CONSTRAINT "Unique_user_id_authority" UNIQUE (user_id, authority),
  ADD CONSTRAINT "FK_Authorities_User" FOREIGN KEY (user_id) REFERENCES public.users(id)
;


--Insert de usuario y password
INSERT INTO users (username, password, enabled) VALUES('SUPERVI01', '$2a$10$HEx.6yYHOW.3/xssX2an8O/dXpgiicxPNKs3oPgHpc7AZ.yVXvWnS', 1);
INSERT INTO users (username, password, enabled) VALUES('SUPERVI02', '$2a$10$p/sSjNd9D4jFo2loc93hi.K7PTXCDXkyN6vIjAv8m0.kZ5G1rLvuy', 1);
INSERT INTO users (username, password, enabled) VALUES('SUPERVI03', '$2a$10$virCz/DLGYCH5v7CHZXgA.QwJIgmCSIbULLDrPd6KCfmCmPhYL3da', 1);
INSERT INTO users (username, password, enabled) VALUES('SUPERVI04', '$2a$10$UU9X1l13hHZuQbV8Bh.UY.22KiQNc/PK0dA6mZ/4lgp5GwpzunKMW', 1);
INSERT INTO users (username, password, enabled) VALUES('SUPERVI05', '$2a$10$q97POk8q9L.D0sKGOHcZYufmTqD9bD6FHzPpo6uyWLzjZcBe9XFdy', 1);
INSERT INTO users (username, password, enabled) VALUES('Leslie', '$2a$10$2KhsPMWZKx.Bo3waK0JEjOcKNmSqaN3r54HQkrVishG5cxLL32GRS', 1);

INSERT INTO authorities (user_id, authority) VALUES(1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(2, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(3, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(4, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(5, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(6, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(6, 'ROLE_ADMIN');

