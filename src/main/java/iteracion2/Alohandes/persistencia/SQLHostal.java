package iteracion2.Alohandes.persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.Hostal;

public class SQLHostal
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
	public SQLHostal (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un Hostal de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id_empresa - id del hostal
	 * @param horario - horario de atención del hostal
	 * @param idSuperI - id del hostal en la superintendencia
	 * @param idCamara - id del hostal en la cámara de comercio
	 * @return El número de tuplas creadas
	 */
	public long crearHostal (PersistenceManager pm, long id_empresa, String horario, String idSuperI, String idCamara)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHostal()+" (ID_EMPRESA,HORARIO_ATENCION,ID_SUPERINTENDENCIA,ID_CAMARA) VALUES ("+id_empresa+",'"+horario+"','"+idSuperI+"','"+idCamara+"')" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Hostal de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la hostal
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarHostal (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHostal () + " WHERE id_empresa = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Hostal de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - El id de la hostal
	 * @return El número de tuplas eliminadas
	 */
	public long buscarHostal (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHostal () + " WHERE id_empresa = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los Hostales
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Hostal> darHostales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHostal () );
		
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Hostal> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				long id = ((BigDecimal)datos[0]).longValue();
				String horario = datos[1].toString();
				String idSuper = datos[2].toString();
				String idCam = datos[3].toString();
				lista.add( new Hostal(id, horario, idSuper, idCam));
		}
		return lista;
	}
	
	public List<Hostal> darHostalesPorServicio (PersistenceManager pm, String servicios)
	{
		String[] serv = servicios.split(",");
		Query q = null;
		if (serv.length==1){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, HORARIO_ATENCION, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHostal() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 1 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOSTAL.ID_EMPRESA");
		}
		if (serv.length == 2){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, HORARIO_ATENCION, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHostal() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' OR NOMBRE_SERVICIO = '" + serv[1] + "'  GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 2 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOSTAL.ID_EMPRESA");
		}
		if (serv.length == 3){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, HORARIO_ATENCION, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHostal() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' OR NOMBRE_SERVICIO = '" + serv[1] + "' OR NOMBRE_SERVICIO = '" + serv[2] + "' GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 3 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOSTAL.ID_EMPRESA");
		}
		if (serv.length == 4){
			q = pm.newQuery(SQL, "SELECT ID_EMPRESA, HORARIO_ATENCION, ID_SUPERINTENDENCIA, ID_CAMARA FROM " + pp.darTablaHostal() + " inner join (SELECT COUNT(*), ID_ALOJAMIENTO"
					+ " FROM " + pp.darTablaAlojamientoServicio() + " WHERE NOMBRE_SERVICIO = '" + serv[0] + "' OR NOMBRE_SERVICIO = '" + serv[1] + "' OR NOMBRE_SERVICIO = '" + serv[2] + "' OR NOMBRE_SERVICIO = '" + serv[3] + "' GROUP BY ID_ALOJAMIENTO "
							+ " HAVING COUNT (*) = 4 ORDER BY ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = HOSTAL.ID_EMPRESA");
		}
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Hostal> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				long id = ((BigDecimal)datos[0]).longValue();
				String horario = datos[1].toString();
				String idSuper = datos[2].toString();
				String idCam = datos[3].toString();
				lista.add( new Hostal(id, horario, idSuper, idCam));
		}
		return lista;
	}
}
