--En este documento se presenta la sentencia SQL utilizada para la creación de una reserva desde JAVA.
--Se usa un ejemplo con valores genéricos de como sería la estructura usual ya que los valores a insertar se ingresan
--por parámetro por el usuario. 

INSERT INTO TIEMPO_OCUPACION (FECHA_LLEGADA,FECHA_SALIDA,ID) VALUES ('05/05/2020','06/05/2020',1);


INSERT INTO RESERVA (estado, fecha, id, cliente_num_doc, cliente_tipo_doc, alojamiento, id_tiempo, precio) VALUES 
				( 'Reserva exitosa', CURRENT_DATE,1,1111111111,'TI',2,1,1 );
