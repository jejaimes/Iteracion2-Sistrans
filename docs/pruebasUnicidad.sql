select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA PROVEEDOR---------------------------------------------'from dual;
INSERT INTO PROVEEDOR (NOMBRE, TIPO_DOCUMENTO, NUM_DOCUMENTO) VALUES ('Joaquin Sabina','CE',1111611111);
INSERT INTO PROVEEDOR (NOMBRE, TIPO_DOCUMENTO, NUM_DOCUMENTO) VALUES ('Joaquin Sabina','CE',1111611111);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA ALOJAMIENTO---------------------------------------------'from dual;
INSERT INTO ALOJAMIENTO (ID, DIRECCION, PROVEEDOR_TIPO_DOC, PROVEEDOR_NUM_DOC) VALUES (1, 'cll 132c #44-44','CE',1111611111);
INSERT INTO ALOJAMIENTO (ID, DIRECCION, PROVEEDOR_TIPO_DOC, PROVEEDOR_NUM_DOC) VALUES (1, 'cll 132c #44-44','CE',1111611111);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA CLIENTE---------------------------------------------'from dual;
INSERT INTO CLIENTE (NOMBRE,TIPO_PERSONA,TIPO_DOCUMENTO,NUM_DOCUMENTO) VALUES ('Pablo Castilla', 'estudiante', 'TI',1111111111);
INSERT INTO CLIENTE (NOMBRE,TIPO_PERSONA,TIPO_DOCUMENTO,NUM_DOCUMENTO) VALUES ('Pablo Castilla', 'estudiante', 'TI',1111111111);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA EMPRESA---------------------------------------------'from dual;
INSERT INTO EMPRESA (ID_ALOJAMIENTO, NOMBRE) VALUES (1,'Torres de la Floresta');
INSERT INTO EMPRESA (ID_ALOJAMIENTO, NOMBRE) VALUES (1,'Torres de la Floresta');

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA HABITACION---------------------------------------------'from dual;
INSERT INTO HABITACION (ID,EMPRESA, NUM_HABITACION, TIPO, UBICACION, CAPACIDAD, COMPARTIDA, TAMANIO) VALUES (1,1,101,'ESTANDAR', 'Primer piso con vista a la calle',2,0,12);
INSERT INTO HABITACION (ID,EMPRESA, NUM_HABITACION, TIPO, UBICACION, CAPACIDAD, COMPARTIDA, TAMANIO) VALUES (1,1,101,'ESTANDAR', 'Primer piso con vista a la calle',2,0,12);

select '-------------------------------------------PRUEBAS DE UNICIDAD TABLA VIVIENDA_UNIVERSITARIA-------------------------------------------'from dual;
INSERT INTO VIVIENDA_UNIVERSITARIA (ID_EMPRESA) VALUES (1);
INSERT INTO VIVIENDA_UNIVERSITARIA (ID_EMPRESA) VALUES (1);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA HOTEL---------------------------------------------'from dual;
INSERT INTO HOTEL (ID_EMPRESA, ID_SUPERINTENDENCIA, ID_CAMARA) VALUES (1, 'G12HT24', 'EQ42H42');
INSERT INTO HOTEL (ID_EMPRESA, ID_SUPERINTENDENCIA, ID_CAMARA) VALUES (1, 'G12HT24', 'EQ42H42');

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA HOSTAL---------------------------------------------'from dual;
INSERT INTO HOSTAL (ID_EMPRESA,HORARIO_ATENCION,ID_SUPERINTENDENCIA,ID_CAMARA) VALUES (1,'8:00-22:00','39FKIO3','TGW34R2Q4');
INSERT INTO HOSTAL (ID_EMPRESA,HORARIO_ATENCION,ID_SUPERINTENDENCIA,ID_CAMARA) VALUES (1,'8:00-22:00','39FKIO3','TGW34R2Q4');

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA INMUEBLE_PERSONA---------------------------------------------'from dual;
INSERT INTO INMUEBLE_PERSONA (TIPO_PROPIETARIO, NUM_HABITACIONES, AMOBLADO, TIPO_INMUEBLE, ID_ALOJAMIENTO) VALUES ('PROFESOR',3,1,'VIVIENDA_ESPORADICA',1);
INSERT INTO INMUEBLE_PERSONA (TIPO_PROPIETARIO, NUM_HABITACIONES, AMOBLADO, TIPO_INMUEBLE, ID_ALOJAMIENTO) VALUES ('PROFESOR',3,1,'VIVIENDA_ESPORADICA',1);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA MENAJE---------------------------------------------'from dual;
INSERT INTO MENAJE (NOMBRE) VALUES ('Sof�');
INSERT INTO MENAJE (NOMBRE) VALUES ('Sof�');

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA MENAJE_INMUEBLE---------------------------------------------'from dual;
INSERT INTO MENAJE_INMUEBLE (ID_INMUEBLE, NOMBRE_MENAJE, CANTIDAD) VALUES (1,'Sof�',3);
INSERT INTO MENAJE_INMUEBLE (ID_INMUEBLE, NOMBRE_MENAJE, CANTIDAD) VALUES (1,'Sof�',3);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA MENAJE_VIVIENDAU---------------------------------------------'from dual;
INSERT INTO MENAJE_VIVIENDAU (ID_VIVIENDAU, NOMBRE_MENAJE, CANTIDAD) VALUES (1,'Sof�',20);
INSERT INTO MENAJE_VIVIENDAU (ID_VIVIENDAU, NOMBRE_MENAJE, CANTIDAD) VALUES (1,'Sof�',20);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA SERVICIO---------------------------------------------'from dual;
INSERT INTO SERVICIO (NOMBRE, DESCRIPCION) VALUES ('Internet','Servicio de internet en el inmueble');
INSERT INTO SERVICIO (NOMBRE, DESCRIPCION) VALUES ('Internet','Servicio de internet en el inmueble');

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA ALOJAMIENTO_SERVICIO---------------------------------------------'from dual;
INSERT INTO ALOJAMIENTO_SERVICIO(NOMBRE_SERVICIO,ID_ALOJAMIENTO,COSTO) VALUES ('Internet',1,70000);
INSERT INTO ALOJAMIENTO_SERVICIO(NOMBRE_SERVICIO,ID_ALOJAMIENTO,COSTO) VALUES ('Internet',1,70000);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA HABITACION_SERVICIO---------------------------------------------'from dual;
INSERT INTO HABITACION_SERVICIO (NOMBRE_SERVICIO, ID_HABITACION, COSTO) VALUES ('Internet',1,0);
INSERT INTO HABITACION_SERVICIO (NOMBRE_SERVICIO, ID_HABITACION, COSTO) VALUES ('Internet',1,0);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA TIEMPO_OCUPACION---------------------------------------------'from dual;
INSERT INTO TIEMPO_OCUPACION (FECHA_LLEGADA,FECHA_SALIDA,ID) VALUES ('05/05/2020','06/05/2020',1);
INSERT INTO TIEMPO_OCUPACION (FECHA_LLEGADA,FECHA_SALIDA,ID) VALUES ('05/05/2020','06/05/2020',1);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA RESERVA---------------------------------------------'from dual;
INSERT INTO RESERVA (ESTADO,FECHA,ID,CLIENTE_NUM_DOC,CLIENTE_TIPO_DOC,ALOJAMIENTO,ID_TIEMPO,PRECIO) VALUES ('A',CURRENT_DATE,1,1111111111,'TI',1,1,1);
INSERT INTO RESERVA (ESTADO,FECHA,ID,CLIENTE_NUM_DOC,CLIENTE_TIPO_DOC,ALOJAMIENTO,ID_TIEMPO,PRECIO) VALUES ('A',CURRENT_DATE,1,1111111111,'TI',1,1,1);

select '---------------------------------------------PRUEBAS DE UNICIDAD TABLA RESERVA_HABITACION---------------------------------------------'from dual;
INSERT INTO RESERVA_HABITACION (ID_RESERVA,ID_HABITACION) VALUES (1,1);
INSERT INTO RESERVA_HABITACION (ID_RESERVA,ID_HABITACION) VALUES (1,1);

select '-------------------------------------------PRUEBAS DE UNICIDAD TABLA INMUEBLE_TIEMPO_OCUPADA-------------------------------------------'from dual;
INSERT INTO INMUEBLE_TIEMPO_OCUPADA (ID_INMUEBLE,ID_TIEMPO) VALUES (1,1);
INSERT INTO INMUEBLE_TIEMPO_OCUPADA (ID_INMUEBLE,ID_TIEMPO) VALUES (1,1);

select '-------------------------------------------PRUEBAS DE UNICIDAD TABLA HABITACION_TIEMPO_OCUPADA-------------------------------------------'from dual;
INSERT INTO HABITACION_TIEMPO_OCUPADA (ID_HABITACION,ID_TIEMPO_OCUPACION) VALUES (1,1);
INSERT INTO HABITACION_TIEMPO_OCUPADA (ID_HABITACION,ID_TIEMPO_OCUPACION) VALUES (1,1);