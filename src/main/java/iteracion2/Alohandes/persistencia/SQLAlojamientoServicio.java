package iteracion2.Alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.AlojamientoServicio;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Reserva;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto AlojamientoServicio de Alohandes
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 */
public class SQLAlojamientoServicio
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
	public SQLAlojamientoServicio (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para crear un AlojamientoServicio de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param servicio - nombre del servicio
	 * @param idAlojamiento - id del alojamiento
	 * @param costo - costo del servicio
	 * @return El número de tuplas creadas
	 */
	public long crearAlojamientoServicio (PersistenceManager pm, String servicio, long idAlojamiento, long costo)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaAlojamientoServicio()+"(NOMBRE_SERVICIO,ID_ALOJAMIENTO,COSTO) VALUES ('"+servicio+"',"+idAlojamiento+","+costo+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de ALOJAMIENTO_SERVICIO de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param servicio - nombre del servicio
	 * @param idAlojamiento - id del alojamiento
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarAlojamientoServicio (PersistenceManager pm, String servicio, long idAlojamiento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlojamientoServicio () + " WHERE nombre_servicio = ? AND id_alojamiento = ?");
        q.setParameters(servicio, idAlojamiento);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de ALOJAMIENTO_SERVICIO de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param servicio - nombre del servicio
	 * @param idAlojamiento - id del alojamiento
	 * @return El número de tuplas eliminadas
	 */
	public long buscarAlojamientoServicio (PersistenceManager pm, String servicio, long idAlojamiento)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAlojamientoServicio () + " WHERE nombre_servicio = ? AND id_alojamiento = ?");
        q.setParameters(servicio, idAlojamiento);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los AlojamientoServicio
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<AlojamientoServicio> darAlojamientoServicio (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAlojamientoServicio() );
		q.setResultClass(AlojamientoServicio.class);
		return (List<AlojamientoServicio>) q.executeList();
	}
}
