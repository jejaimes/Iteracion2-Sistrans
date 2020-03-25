package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.InmuebleTiempoOcupada;
import iteracion2.Alohandes.negocio.InmuebleTiempoOcupada;

public class SQLInmuebleTiempoOcupada
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
	public SQLInmuebleTiempoOcupada (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un InmuebleTiempoOcupada de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idInmueble - id de la inmueble
	 * @param idTiempo - id del tiempo ocupacion
	 * @return El número de tuplas creadas
	 */
	public long crearInmuebleTiempoOcupada (PersistenceManager pm, long idInmueble, long idTiempo)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaInmuebleTiempoOcupada()+"(ID_INMUEBLE,ID_TIEMPO_OCUPACION) VALUES ("+idInmueble+","+idTiempo+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de InmuebleTiempoOcupada de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idInmueble - id de la inmueble
	 * @param idTiempo - id del tiempo ocupacion
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarInmuebleTiempoOcupada (PersistenceManager pm, long idInmueble, long idTiempo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmuebleTiempoOcupada () + " WHERE id_inmueble = ? AND id_tiempo = ?");
        q.setParameters(idInmueble, idTiempo);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de InmuebleTiempoOcupada de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idInmueble - id de la inmueble
	 * @param idTiempo - id del tiempo ocupacion
	 * @return El número de tuplas eliminadas
	 */
	public long buscarInmuebleTiempoOcupada (PersistenceManager pm, long idInmueble, long idTiempo)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmuebleTiempoOcupada () + " WHERE id_inmueble = ? AND id_tiempo = ?");
        q.setParameters(idInmueble, idTiempo);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los InmuebleTiempoOcupada
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos InmuebleTiempoOcupada
	 */
	public List<InmuebleTiempoOcupada> darInmuebleTiempoOcupada (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmuebleTiempoOcupada() );
		q.setResultClass(InmuebleTiempoOcupada.class);
		return (List<InmuebleTiempoOcupada>) q.executeList();
	}
}
