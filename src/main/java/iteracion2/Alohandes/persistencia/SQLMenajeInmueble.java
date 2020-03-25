package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.MenajeInmueble;
import iteracion2.Alohandes.negocio.Proveedor;

public class SQLMenajeInmueble
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
	public SQLMenajeInmueble (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un MenajeInmueble de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idInmueble - id del inmueble
	 * @param menaje - menaje del inmueble
	 * @param cantidad - cantidad del menaje
	 * @return El número de tuplas creadas
	 */
	public long crearMenajeInmueble (PersistenceManager pm, long idInmueble, String menaje, int cantidad)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaMenajeInmueble()+" (ID_VIVIENDAU, NOMBRE_MENAJE, CANTIDAD) VALUES ("+idInmueble+",'"+menaje+"',"+cantidad+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de MenajeInmueble de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idInmueble - id del inmueble
	 * @param menaje - menaje del inmueble
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarMenajeInmueble (PersistenceManager pm, long idInmueble, String menaje)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMenajeInmueble () + " WHERE id_inmueble = ? AND nombre_menaje = ?");
        q.setParameters(idInmueble,menaje);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de MenajeInmueble de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idInmueble - id del inmueble
	 * @param menaje - menaje del inmueble
	 * @return El número de tuplas eliminadas
	 */
	public long buscarMenajeInmueble (PersistenceManager pm, long idInmueble, String menaje)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMenajeInmueble () + " WHERE id_inmueble = ? AND nombre_menaje = ?");
        q.setParameters(idInmueble,menaje);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los MenajeInmuebles
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<MenajeInmueble> darMenajeInmuebles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMenajeInmueble() );
		q.setResultClass(MenajeInmueble.class);
		return (List<MenajeInmueble>) q.executeList();
	}
}
