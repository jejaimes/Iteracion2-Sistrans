package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import iteracion2.Alohandes.negocio.Menaje;

public class SQLMenaje
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
	public SQLMenaje (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear una tupla Menaje de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre del menaje
	 * @return El número de tuplas creadas
	 */
	public long crearMenaje (PersistenceManager pm, String nombre)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaMenaje()+" (NOMBRE) VALUES ('"+nombre+"')" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Menaje de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre del menaje
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarMenaje (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMenaje () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Menaje de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - El nombre del menaje
	 * @return El número de tuplas eliminadas
	 */
	public long buscarMenaje(PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMenaje () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todos los Menajes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Menaje> darMenajes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMenaje() );
		q.setResultClass(Menaje.class);
		return (List<Menaje>) q.executeList();
	}
}
