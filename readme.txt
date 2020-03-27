Pasos a seguir para el correcto funcionamiento de la aplicación:
1. En la carpeta \src\main\resources\META-INF\ se encuentra el archivo persistence.XML. Abralo con block de notas y en la línea de "Parranderos unit", agregue
   a la linea <property name="javax.jdo.option.ConnectionUserName" y a la linea <property name="javax.jdo.option.ConnectionPassword" sus credenciales de acceso  
   a la base de datos, su nombre de usuario y contraseña. En caso de no tener credenciales, usar estas: 
	Nombre de usuario: ISIS2304A182010
	Contraseña: cUQXNSeThjGe

2. Inicie SQLDeveloper e ingrese a la base de datos con sus credenciales o con las propuestas en el numeral anterior.

3. En la carpeta  \docs\ se encuentran los archivos CreacionTablas.sql y PoblarTablas.sql, abra los archivos desde SQLDeveloper

4. Primero, ejecute el script del archivo CreacionTablas.sql, una vez se terminó de ejecutar, ejecute el script del archivo PoblatTablas.sql

5. Entre a Java Eclipse, cargue el archivo como nuevo proyecto.

6. Ejecute primero los test para rectificar la conexión correcta con la base de datos y los test de los requerimientos implementados.

7. Después de correr los test, ejecute la aplicación. Se desplegará el menú desde la consola. Puede explorar las diferentes funciones mostradas.

RECUERDE SEGUIR LAS INSTRUCCIONES PASO A PASO, TANTO LAS DE ESTE ARCHIVO COMO LAS QUE SE DESPLIEGAN EN CONSOLA UNA VEZ SE CORRE EL PROGRAMA.