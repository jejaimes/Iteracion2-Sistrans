package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Empresa;

public class SQLEmpresa
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
	public SQLEmpresa (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un Empresa de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la empresa. Es foreign key de id en alojamiento
	 * @param nombre - el nombre del empresa
	 * @return El número de tuplas creadas
	 */
	public long crearEmpresa (PersistenceManager pm, long id, String nombre)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaEmpresa()+" (ID_ALOJAMIENTO, NOMBRE) VALUES ("+id+",'"+nombre+"')" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Empresa de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la empresa
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarEmpresa (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpresa () + " WHERE id_alojamiento = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Empresa de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la empresa
	 * @return El número de tuplas eliminadas
	 */
	public long buscarEmpresa (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpresa () + " WHERE id_alojamiento = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los Empresas
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Empresa> darEmpresas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpresa() );
		q.setResultClass(Empresa.class);
		return (List<Empresa>) q.executeList();
	}
}
