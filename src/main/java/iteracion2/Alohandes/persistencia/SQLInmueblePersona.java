package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.InmueblePersona;

public class SQLInmueblePersona
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
	public SQLInmueblePersona (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un InmueblePersona de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param tipoPropietario - el tipo de propietario
	 * @param numHabitaciones - el número de habitaciones
	 * @param amoblado - si está amoblado o no
	 * @param tipoInmueble - el tipo de inmueble
	 * @param idAlojamiento - id del inmueble
	 * @return El número de tuplas creadas
	 */
	public long crearInmueblePersona (PersistenceManager pm, String tipoPropietario, int numHabitaciones, boolean amoblado, String tipoInmueble, long idAlojamiento)
	{
		try{
			Query q;
			if(amoblado){
				q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacion()+" (TIPO_PROPIETARIO, NUM_HABITACIONES, AMOBLADO, TIPO_INMUEBLE, ID_ALOJAMIENTO) VALUES ('"+tipoPropietario+"',"+numHabitaciones+",1,'"+tipoInmueble+"',"+idAlojamiento+")" );
			}
			else{
				q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacion()+" (TIPO_PROPIETARIO, NUM_HABITACIONES, AMOBLADO, TIPO_INMUEBLE, ID_ALOJAMIENTO) VALUES ('"+tipoPropietario+"',"+numHabitaciones+",0,'"+tipoInmueble+"',"+idAlojamiento+")" );
			}
			
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de InmueblePersona de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - id del inmueblePersona
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarInmueblePersona (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmueblePersona () + " WHERE WHERE id_alojamiento = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de InmueblePersona de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - id del inmueblePersona
	 * @return El número de tuplas eliminadas
	 */
	public long buscarInmueblePersona (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueblePersona () + " WHERE WHERE id_alojamiento = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los InmueblePersonaes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<InmueblePersona> darInmueblePersonas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueblePersona() );
		q.setResultClass(InmueblePersona.class);
		return (List<InmueblePersona>) q.executeList();
	}
}
