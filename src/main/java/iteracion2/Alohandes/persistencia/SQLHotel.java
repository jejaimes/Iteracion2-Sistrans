package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Hotel;

public class SQLHotel
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
	public SQLHotel (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un Hotel de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id_empresa - id del hotel
	 * @param idSuperI - id del hotel en la superintendencia
	 * @param idCamara - id del hotel en la cámara de comercio
	 * @return El número de tuplas creadas
	 */
	public long crearHotel (PersistenceManager pm, long id_empresa, String idSuperI, String idCamara)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHotel()+" (ID_EMPRESA,ID_SUPERINTENDENCIA,ID_CAMARA) VALUES ("+id_empresa+"','"+idSuperI+"','"+idCamara+"')" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Hotel de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la hotel
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarHotel (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE id_empresa = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Hotel de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la hotel
	 * @return El número de tuplas eliminadas
	 */
	public long buscarHotel (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE id_empresa = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los Hoteles
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Hotel> darHotels (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel() );
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
}
