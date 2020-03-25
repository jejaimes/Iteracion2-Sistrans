package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.ViviendaUniversitaria;

public class SQLViviendaUniversitaria
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
	public SQLViviendaUniversitaria (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear una ViviendaUniversitaria de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id_empresa - id de la vivienda universitaria
	 * @return El número de tuplas creadas
	 */
	public long crearViviendaUniversitaria (PersistenceManager pm, long id_empresa)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHostal()+" (ID_EMPRESA) VALUES ("+id_empresa+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de ViviendaUniversitaria de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la viviendaUniversitaria
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarViviendaUniversitaria (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaViviendaUniversitaria () + " WHERE id_empresa = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de ViviendaUniversitaria de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la viviendaUniversitaria
	 * @return El número de tuplas eliminadas
	 */
	public long buscarViviendaUniversitaria (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaViviendaUniversitaria () + " WHERE id_empresa = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los ViviendaUniversitariaes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<ViviendaUniversitaria> darViviendaUniversitarias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaViviendaUniversitaria() );
		q.setResultClass(ViviendaUniversitaria.class);
		return (List<ViviendaUniversitaria>) q.executeList();
	}
}
