package iteracion2.Alohandes.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLTiempoOcupacion
{
	/*****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohandes.SQL;

	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaAlohandes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLTiempoOcupacion (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un tiempo de estadia de la base de datos de Alohandes.
	 * @param pm - El manejador de persistencia
	 * @param id - El id del alojamiento
	 * @return EL número de tuplas eliminadas
	 */
	public long crearTiempoOcupacion (PersistenceManager pm, Timestamp fechaLlegada, Timestamp fechaSalida, long id )
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTiempoOcupacion() + "(fecha_llegada, fecha_salida, id) values (?, ?, ?)");
        q.setParameters(fechaLlegada, fechaSalida,id);
        return (long) q.executeUnique();
	}
	
}
