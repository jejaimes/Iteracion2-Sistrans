package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import iteracion2.Alohandes.negocio.HabitacionServicio;

public class SQLHabitacionServicio
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
	public SQLHabitacionServicio (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un HabitacionServicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param servicio - nombre del servicio
	 * @param idHabitacion - id del habitacion
	 * @param costo - costo del servicio
	 * @return El número de tuplas creadas
	 */
	public long crearHabitacionServicio (PersistenceManager pm, String servicio, long idHabitacion, long costo)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacionServicio()+"(NOMBRE_SERVICIO,ID_HABITACION,COSTO) VALUES ('"+servicio+"',"+idHabitacion+","+costo+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de HabitacionServicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param servicio - nombre del servicio
	 * @param idHabitacion - id del habitacion
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarHabitacionServicio (PersistenceManager pm, String servicio, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionServicio () + " WHERE nombre_servicio = ? AND id_habitacion = ?");
        q.setParameters(servicio, idHabitacion);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de HabitacionServicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param servicio - nombre del servicio
	 * @param idHabitacion - id del habitacion
	 * @return El número de tuplas eliminadas
	 */
	public long buscarHabitacionServicio (PersistenceManager pm, String servicio, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacionServicio () + " WHERE nombre_servicio = ? AND id_habitacion = ?");
        q.setParameters(servicio, idHabitacion);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los HabitacionServicio
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos HabitacionServicio
	 */
	public List<HabitacionServicio> darHabitacionServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacionServicio() );
		q.setResultClass(HabitacionServicio.class);
		return (List<HabitacionServicio>) q.executeList();
	}
}
