package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.MenajeViviendaU;

public class SQLMenajeViviendaU
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
	public SQLMenajeViviendaU (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un MenajeViviendaU de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idViviendaU - id de la vivienda universitaria
	 * @param menaje - menaje de la vivienda universitaria
	 * @param cantidad - cantidad del menaje
	 * @return El número de tuplas creadas
	 */
	public long crearMenajeViviendaU (PersistenceManager pm, long idViviendaU, String menaje, int cantidad)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaMenajeViviendaU()+" (ID_VIVIENDAU, NOMBRE_MENAJE, CANTIDAD) VALUES ("+idViviendaU+",'"+menaje+"',"+cantidad+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de MenajeViviendaU de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idViviendaU - id de la vivienda universitaria
	 * @param menaje - menaje de la vivienda universitaria
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarMenajeViviendaU (PersistenceManager pm, long idViviendaU, String menaje)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMenajeViviendaU () + " WHERE id_viviendau = ? AND nombre_menaje = ?");
        q.setParameters(idViviendaU,menaje);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de MenajeViviendaU de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param idViviendaU - id de la vivienda universitaria
	 * @param menaje - menaje de la vivienda universitaria
	 * @return El número de tuplas eliminadas
	 */
	public long buscarMenajeViviendaU (PersistenceManager pm, long idViviendaU, String menaje)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMenajeViviendaU () + " WHERE id_viviendau = ? AND nombre_menaje = ?");
        q.setParameters(idViviendaU,menaje);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los MenajeViviendaUs
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<MenajeViviendaU> darMenajeViviendaUs (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMenajeViviendaU() );
		q.setResultClass(MenajeViviendaU.class);
		return (List<MenajeViviendaU>) q.executeList();
	}
}
