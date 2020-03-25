package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.HabitacionTiempoOcupada;

public class SQLHabitacionTiempoOcupada
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
	public SQLHabitacionTiempoOcupada (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un HabitacionTiempoOcupada de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idHabitacion - id de la habitacion
	 * @param idTiempo - id del tiempo ocupacion
	 * @return El número de tuplas creadas
	 */
	public long crearHabitacionTiempoOcupada (PersistenceManager pm, long idHabitacion, long idTiempo)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacionTiempoOcupada()+"(ID_HABITACION,ID_TIEMPO_OCUPACION) VALUES ("+idHabitacion+","+idTiempo+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de HabitacionTiempoOcupada de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idHabitacion - id de la habitacion
	 * @param idTiempo - id del tiempo ocupacion
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarHabitacionTiempoOcupada (PersistenceManager pm, long idHabitacion, long idTiempo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionTiempoOcupada () + " WHERE id_habitacion = ? AND id_tiempo_ocupacion = ?");
        q.setParameters(idHabitacion, idTiempo);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de HabitacionTiempoOcupada de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idHabitacion - id de la habitacion
	 * @param idTiempo - id del tiempo ocupacion
	 * @return El número de tuplas eliminadas
	 */
	public long buscarHabitacionTiempoOcupada (PersistenceManager pm, long idHabitacion, long idTiempo)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacionTiempoOcupada () + " WHERE id_habitacion = ? AND id_tiempo_ocupacion = ?");
        q.setParameters(idHabitacion, idTiempo);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los HabitacionTiempoOcupada
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos HabitacionTiempoOcupada
	 */
	public List<HabitacionTiempoOcupada> darHabitacionTiempoOcupada (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacionTiempoOcupada() );
		q.setResultClass(HabitacionTiempoOcupada.class);
		return (List<HabitacionTiempoOcupada>) q.executeList();
	}
}
