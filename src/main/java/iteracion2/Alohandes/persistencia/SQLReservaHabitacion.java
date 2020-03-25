package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.ReservaHabitacion;

public class SQLReservaHabitacion
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
	public SQLReservaHabitacion (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un ReservaHabitacion de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idReserva - El id de la reserva
	 * @param idHabitacion - El id de la habitación
	 * @return El número de tuplas creadas
	 */
	public long crearReservaHabitacion (PersistenceManager pm, long idReserva, long idHabitacion)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaReservaHabitacion()+" (ID_RESERVA,ID_HABITACION) VALUES ("+idReserva+","+idHabitacion+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de ReservaHabitacion de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idReserva - El id de la reserva
	 * @param idHabitacion - El id de la habitación
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarReservaHabitacion (PersistenceManager pm, long idReserva, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaHabitacion () + " WHERE id_reserva = ? AND id_habitacion = ?");
        q.setParameters(idReserva,idHabitacion);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de ReservaHabitacion de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idReserva - El id de la reserva
	 * @param idHabitacion - El id de la habitación
	 * @return El número de tuplas eliminadas
	 */
	public long buscarReservaHabitacion (PersistenceManager pm, long idReserva, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaHabitacion () + " WHERE id_reserva = ? AND id_habitacion = ?");
        q.setParameters(idReserva,idHabitacion);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los ReservaHabitaciones
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<ReservaHabitacion> darReservaHabitacions (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaHabitacion() );
		q.setResultClass(ReservaHabitacion.class);
		return (List<ReservaHabitacion>) q.executeList();
	}
}
