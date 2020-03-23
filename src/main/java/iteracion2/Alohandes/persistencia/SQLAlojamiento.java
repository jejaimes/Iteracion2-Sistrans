package iteracion2.Alohandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.Reserva;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 */
class SQLAlojamiento 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohandes.SQL;

	/* ****************************************************************
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
	public SQLAlojamiento (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar ALOJAMIENTO de la base de datos de Alohandes, por su id
	 * @param pm - El manejador de persistencia
	 * @param id - El id del alojamiento
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAlojamientoPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlojamiento () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}




	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALOJAMIENTOS de la 
	 * base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ALOJAMIENTO
	 */
	public List<Alojamiento> darAlojamientos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAlojamiento ());
		System.out.println("Estoy haciendo algoooooooooo");
		q.setResultClass(Alojamiento.class);
		return (List<Alojamiento>) q.executeList();
	}
	
	public Alojamiento darAlojamientoId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE id = ?");
		q.setResultClass(Alojamiento.class);
		q.setParameters(id);
		return (Alojamiento) q.executeUnique();
	}

	
}
