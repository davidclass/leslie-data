/* Insert table Sctrp */
INSERT INTO sctrp (id, codigo, emision, vencimiento) VALUES(1, '7010511700767P', '2020-07-01', '2020-07-31');
INSERT INTO sctrp (id, codigo, emision, vencimiento) VALUES(2, '7010511700768P', '2020-07-01', '2020-07-31');

/* Insert table Sctrs */
INSERT INTO sctrs (id, codigo, emision, vencimiento) VALUES(1, '7010511700767S', '2020-07-01', '2020-07-31');
INSERT INTO sctrs (id, codigo, emision, vencimiento) VALUES(2, '7010511700768S', '2020-07-01', '2020-07-31');

/* Insert table Carnets */
INSERT INTO carnets (id, codigo, emision, vencimiento) VALUES(1, '021745', '2020-07-01', '2020-07-31');
INSERT INTO carnets (id, codigo, emision, vencimiento) VALUES(2, '021746', '2020-07-01', '2020-07-31');
INSERT INTO carnets (id, codigo, emision, vencimiento) VALUES(3, '021747', '2020-07-01', '2020-07-31');
INSERT INTO carnets (id, codigo, emision, vencimiento) VALUES(4, '021748', '2020-07-01', '2020-07-31');
INSERT INTO carnets (id, codigo, emision, vencimiento) VALUES(5, '021749', '2020-07-01', '2020-07-31');

/* Insert table Inducciones */
INSERT INTO inducciones (id, emision, vencimiento) VALUES(1, '2020-07-01', '2020-07-31');
INSERT INTO inducciones (id, emision, vencimiento) VALUES(2, '2020-08-01', '2020-08-31');

/* Insert table documentos */
INSERT INTO documentos (id, nombre) VALUES(1, 'DNI');
INSERT INTO documentos (id, nombre) VALUES(2, 'PAS');
INSERT INTO documentos (id, nombre) VALUES(3, 'PTP');
INSERT INTO documentos (id, nombre) VALUES(4, 'PEX');
INSERT INTO documentos (id, nombre) VALUES(5, 'CDI');

/* Insert table colaboradores */
INSERT INTO colaboradores (id, nombre, apellido, documento_id, numero_doc, empresa, fech_nac, sctrp_id, sctrs_id, carnets_id, induccion_id)  VALUES(1, 'MARGARET CRISTIN', 'ZAMBRANO  PARICA', 1, '00388803', 'Frozen', '2020-07-31', 1, 1, 1, 1);
INSERT INTO colaboradores (id, nombre, apellido, documento_id, numero_doc, empresa, fech_nac, sctrp_id, sctrs_id, carnets_id, induccion_id)  VALUES(2, 'RAFAEL ANTONIO', 'SUAREZ TORREALBA', 2, '28478463', 'Frozen', '2020-07-31', 1, 1, 2, 1);
INSERT INTO colaboradores (id, nombre, apellido, documento_id, numero_doc, empresa, fech_nac, sctrp_id, sctrs_id, carnets_id, induccion_id)  VALUES(3, 'MICHELL ALFONZO', 'SERMEÑO  ESCOBAR', 3, '2374748', 'Frozen', '2020-07-31', 1, 1, 3, 1);
INSERT INTO colaboradores (id, nombre, apellido, documento_id, numero_doc, empresa, fech_nac, sctrp_id, sctrs_id, carnets_id, induccion_id)  VALUES(4, 'YEISON ABEL', 'BAUTISTA ARCIA', 4, '109318846', 'Frozen', '2020-07-31', 2, 2, 4, 2);
INSERT INTO colaboradores (id, nombre, apellido, documento_id, numero_doc, empresa, fech_nac, sctrp_id, sctrs_id, carnets_id, induccion_id)  VALUES(5, 'JUAN JOSE', 'BRUCE ALVARADO', 5, '20446299', 'Frozen', '2020-07-31', 2, 2, 5, 2);

