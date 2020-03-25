package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Habitacion;

public class SQLHabitacion
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
	public SQLHabitacion (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un Habitacion de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param empresa - el id de la empresa a la que pertenece la habitacion
	 * @param numHabitacion - el número de habitación
	 * @param tipo - el tipo de habitación
	 * @param ubicacion - la ubicación de la habitación
	 * @param capacidad - capaciadad de la habitación
	 * @param compartida - si la habitación es compartida o no
	 * @param tamanio - el tamaño de la habitación
	 * @return El número de tuplas creadas
	 */
	public long crearHabitacion (PersistenceManager pm, long empresa, int numHabitacion, String tipo, String ubicacion, int capacidad, boolean compartida, int tamanio)
	{
		try{
			Query q;
			if(compartida){
				q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacion()+" (EMPRESA, NUM_HABITACION, TIPO, UBICACION, CAPACIDAD, COMPARTIDA, TAMANIO) VALUES ("+empresa+","+numHabitacion+",'"+tipo+"','"+ubicacion+"',"+capacidad+",1,"+tamanio+")" );
			}
			else{
				q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacion()+" (EMPRESA, NUM_HABITACION, TIPO, UBICACION, CAPACIDAD, COMPARTIDA, TAMANIO) VALUES ("+empresa+","+numHabitacion+",'"+tipo+"','"+ubicacion+"',"+capacidad+",0,"+tamanio+")" );
			}
			
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Habitacion de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la habitacion
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarHabitacion (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Habitacion de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la habitacion
	 * @return El número de tuplas eliminadas
	 */
	public long buscarHabitacion (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los Habitacions
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Habitacion> darHabitacions (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion() );
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}
}
