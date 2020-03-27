package iteracion2.Alohandes.persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Hostal;
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
	public List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel() );
		
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Hotel> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				long id = ((BigDecimal)datos[0]).longValue();
				String idSuper = datos[1].toString();
				String idCam = datos[2].toString();
				lista.add( new Hotel(id, idSuper, idCam));
		}
		return lista;
	}
	
	public List<Hotel> darHotelesPorServicio (PersistenceManager pm, String servicios)
	{
		String[] serv = servicios.split(",");
		Query q = null;
		if (serv.length==1){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHotel() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 1 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOTEL.ID_EMPRESA");
		}
		if (serv.length == 2){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHotel() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' OR NOMBRE_SERVICIO = '" + serv[1] + "'  GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 2 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOTEL.ID_EMPRESA");
		}
		if (serv.length == 3){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHotel() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' OR NOMBRE_SERVICIO = '" + serv[1] + "' OR NOMBRE_SERVICIO = '" + serv[2] + "' GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 3 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOTEL.ID_EMPRESA");
		}
		if (serv.length == 4){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHotel() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' OR NOMBRE_SERVICIO = '" + serv[1] + "' OR NOMBRE_SERVICIO = '" + serv[2] + "' OR NOMBRE_SERVICIO = '" + serv[3] + "' GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 4 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOTEL.ID_EMPRESA");
		}
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Hotel> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				long id = ((BigDecimal)datos[0]).longValue();
				String idSuper = datos[1].toString();
				String idCam = datos[2].toString();
				lista.add( new Hotel(id, idSuper, idCam));
		}
		return lista;
	}
}
