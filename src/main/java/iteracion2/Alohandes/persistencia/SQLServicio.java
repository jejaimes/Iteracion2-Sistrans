package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Servicio;

public class SQLServicio
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
	public SQLServicio (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un Servicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - nombre del servicio
	 * @param descripcion - la descripción del servicio
	 * @return El número de tuplas creadas
	 */
	public long crearServicio (PersistenceManager pm, String nombre, String descripcion)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaServicio()+" (NOMBRE,DESCRIPCION) VALUES ('"+nombre+"','"+descripcion+"')" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Servicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre de la servicio
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarServicio (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Servicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre de la servicio
	 * @return El número de tuplas eliminadas
	 */
	public long buscarServicio (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los Servicioes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() );
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
}
