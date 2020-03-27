package iteracion2.Alohandes.persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Hotel;
import iteracion2.Alohandes.negocio.InmueblePersona;

public class SQLInmueblePersona
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
	public SQLInmueblePersona (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para crear un InmueblePersona de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param tipoPropietario - el tipo de propietario
	 * @param numHabitaciones - el número de habitaciones
	 * @param amoblado - si está amoblado o no
	 * @param tipoInmueble - el tipo de inmueble
	 * @param idAlojamiento - id del inmueble
	 * @return El número de tuplas creadas
	 */
	public long crearInmueblePersona (PersistenceManager pm, String tipoPropietario, int numHabitaciones, boolean amoblado, String tipoInmueble, long idAlojamiento)
	{
		try{
			Query q;
			if(amoblado){
				q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacion()+" (TIPO_PROPIETARIO, NUM_HABITACIONES, AMOBLADO, TIPO_INMUEBLE, ID_ALOJAMIENTO) VALUES ('"+tipoPropietario+"',"+numHabitaciones+",1,'"+tipoInmueble+"',"+idAlojamiento+")" );
			}
			else{
				q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaHabitacion()+" (TIPO_PROPIETARIO, NUM_HABITACIONES, AMOBLADO, TIPO_INMUEBLE, ID_ALOJAMIENTO) VALUES ('"+tipoPropietario+"',"+numHabitaciones+",0,'"+tipoInmueble+"',"+idAlojamiento+")" );
			}

			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de InmueblePersona de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - id del inmueblePersona
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarInmueblePersona (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmueblePersona () + " WHERE WHERE id_alojamiento = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de InmueblePersona de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - id del inmueblePersona
	 * @return El número de tuplas eliminadas
	 */
	public long buscarInmueblePersona (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueblePersona () + " WHERE WHERE id_alojamiento = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los InmueblePersonaes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<InmueblePersona> darInmueblePersonas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueblePersona() );

		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<InmueblePersona> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
			boolean am = false;
			String tipoPer = datos[0].toString();
			int hab = ((BigDecimal)datos[1]).intValue();
			int amoblado = ((BigDecimal)datos[2]).intValue();
			if(amoblado == 1) am = true;
			String tipoIn = datos[3].toString();
			long id = ((BigDecimal)datos[4]).longValue();
			lista.add( new InmueblePersona(tipoPer, hab, am, tipoIn, id));
		}
		return lista;
	}

	public List<InmueblePersona> darInmueblesPorServicio (PersistenceManager pm, String servicios)
	{
		String[] serv = servicios.split(",");
		for (int i = 0; i < serv.length; i++) {
			if (serv[i].equals("tvcable")) serv[i] = "TV Cable";
			if (serv[i].equals("serviciospublicos")) serv[i] = "Servicios públicos";
			if (serv[i].equals("serviciodeaseo")) serv[i] = "Servicio de aseo";
			if (serv[i].equals("bañoprivado")) serv[i] = "Baño privado";
			if (serv[i].equals("cocineta")) serv[i] = "Cocineta";
			if (serv[i].equals("parqueadero")) serv[i] = "Parqueadero";
			if (serv[i].equals("comidas")) serv[i] = "Comidas";
			if (serv[i].equals("internet")) serv[i] = "Internet";
			if (serv[i].equals("bañera")) serv[i] = "Bañera";
		}
		Query q = null;
		if (serv.length==1){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 1 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 2){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 2 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 3){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 3 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 4){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' OR AL.NOMBRE_SERVICIO = '" + serv[3] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 4 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 5){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' OR AL.NOMBRE_SERVICIO = '" + serv[3] + 
					"' OR AL.NOMBRE_SERVICIO = '" + serv[4] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 5 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 6){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' OR AL.NOMBRE_SERVICIO = '" + serv[3] + 
					"' OR AL.NOMBRE_SERVICIO = '" + serv[4] + "' OR AL.NOMBRE_SERVICIO = '" + serv[5] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 6 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 7){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' OR AL.NOMBRE_SERVICIO = '" + serv[3] + 
					"' OR AL.NOMBRE_SERVICIO = '" + serv[4] + "' OR AL.NOMBRE_SERVICIO = '" + serv[5] + "' OR AL.NOMBRE_SERVICIO = '" + serv[6] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 7 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 8){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' OR AL.NOMBRE_SERVICIO = '" + serv[3] + 
					"' OR AL.NOMBRE_SERVICIO = '" + serv[4] + "' OR AL.NOMBRE_SERVICIO = '" + serv[5] + "' OR AL.NOMBRE_SERVICIO = '" + serv[6] + "' OR AL.NOMBRE_SERVICIO = '" + serv[7] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 8 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		if (serv.length == 9){
			q = pm.newQuery(SQL, "SELECT  INPER.TIPO_PROPIETARIO, INPER.NUM_HABITACIONES, INPER.AMOBLADO, INPER.TIPO_INMUEBLE, INPER.ID_ALOJAMIENTO FROM " + pp.darTablaInmueblePersona() +
					" INPER inner join (SELECT COUNT(*), ID_ALOJAMIENTO  FROM " + pp.darTablaAlojamientoServicio() + 
					" AL  WHERE AL.NOMBRE_SERVICIO = '" + serv[0] + "' OR AL.NOMBRE_SERVICIO = '" + serv[1] + "'  OR AL.NOMBRE_SERVICIO = '" + serv[2] + "' OR AL.NOMBRE_SERVICIO = '" + serv[3] + 
					"' OR AL.NOMBRE_SERVICIO = '" + serv[4] + "' OR AL.NOMBRE_SERVICIO = '" + serv[5] + "' OR AL.NOMBRE_SERVICIO = '" + serv[6] + "' OR AL.NOMBRE_SERVICIO = '" + serv[7] + "' OR AL.NOMBRE_SERVICIO = '" + serv[8] + "' GROUP BY AL.ID_ALOJAMIENTO "
					+ " HAVING COUNT (*) = 9 ORDER BY AL.ID_ALOJAMIENTO) T ON T.ID_ALOJAMIENTO = INPER.ID_alojamiento");
		}
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<InmueblePersona> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
			boolean am = false;
			String tipoPer = datos[0].toString();
			int hab = ((BigDecimal)datos[1]).intValue();
			int amoblado = ((BigDecimal)datos[2]).intValue();
			if(amoblado == 1) am = true;
			String tipoIn = datos[3].toString();
			long id = ((BigDecimal)datos[4]).longValue();
			lista.add( new InmueblePersona(tipoPer, hab, am, tipoIn, id));
		}
		return lista;
	}
}
